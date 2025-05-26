package com.app.divyansh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = Access.READ_ONLY)
    @Column(name="uid")
    private Long id;
    @Column(name="uname")
    private String username;
    @Column(name="ufname")
    private String firstName;
    @Column(name="ulname")
    private String lastName;
    @Column(name="umail")
    private String email;
    @Column(name="upassword")
    private String password;
    @Column(name="uphone")
    private String phone;
    @Column(name="ustatus")
    private Integer userStatus; 
}