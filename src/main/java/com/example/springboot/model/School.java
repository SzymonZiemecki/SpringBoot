package com.example.springboot.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class School {

    @Id
    private long id;
    private String Name;

    @OneToMany
    @JoinColumn(name = "schoolId")
    private List<Student> studentList;
}
