package com.app.divyansh.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bid")
    private Long id;
    @Column(name="btitle")
    private String title;
    @Column(name="bauthor")
    private String author;
    @Column(name="bisbn")
    private String isbn;
    @Column(name="bprice")
    private Double price;
}