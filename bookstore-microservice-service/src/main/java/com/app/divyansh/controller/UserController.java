package com.app.divyansh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.divyansh.model.User;
import com.app.divyansh.service.UserService;
import com.app.divyansh.utility.SessionManager;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name="Users", description="User management APIs")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SessionManager sessionManager;

    @PostMapping("/createWithList")
    public ResponseEntity<List<User>> createWithList(@RequestBody List<User> users) {
        return ResponseEntity.ok(userService.saveAllUsers(users));
    }

    @GetMapping("/{username}")
    @Operation(summary="get user from username")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        return ResponseEntity.of(userService.getUserByUsername(username));
    }

    @GetMapping("/all")
    @Operation(summary="get all the users from db")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PutMapping("/{username}")
    @Operation(summary="update the user")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user,
    		@RequestHeader("x-auth-token") String token){
    	if(!sessionManager.isValid(token) || !sessionManager.getUsername(token).equals(username)){
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    	}
        return ResponseEntity.ok(userService.updateUser(username, user));
    }

    @DeleteMapping("/{username}")
    @Operation(summary="delete user from username")
    public ResponseEntity<Void> deleteUser(@PathVariable String username){
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/register")
    @Operation(summary="register first time users")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
    	return ResponseEntity.ok(userService.saveUser(user));
    }
    
    @PostMapping("/login")
    @Operation(summary = "Login the user and start session")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        boolean isValid = userService.validateCredentials(username, password);
        if (!isValid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        String sessionToken = sessionManager.createSession(username);
        return ResponseEntity.ok()
                .header("x-auth-token", sessionToken)
                .body("Login is successful for user. Token is generated.");
    }

    @PostMapping("/logout")
    @Operation(summary = "Logout the user and terminate session")
    public ResponseEntity<String> logout(@RequestHeader("x-auth-token") String token) {
        if (sessionManager.isValid(token)) {
            sessionManager.invalidate(token);
            return ResponseEntity.ok("User logged out successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid session token");
        }
    }
}
