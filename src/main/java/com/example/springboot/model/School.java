package com.example.springboot.model;


import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "schoolId", updatable = false, insertable = false)
    private List<Student> studentList;
}
