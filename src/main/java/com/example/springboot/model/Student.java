package com.example.springboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private long schoolId;
    private String Name;
    private String Surname;
}
