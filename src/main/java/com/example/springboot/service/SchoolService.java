package com.example.springboot.service;


import com.example.springboot.model.School;
import com.example.springboot.model.Student;
import com.example.springboot.repositories.SchoolRepository;
import com.example.springboot.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;
    private static final int PAGE_SIZE = 5;

    public List<School> getSchoolsWithStudents(int page, Sort.Direction sort) {
        List<School> allSchools = schoolRepository.findAllSchools(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
        List<Long> ids = allSchools.stream()
                .map(school -> school.getId())
                .collect(Collectors.toList());
        List<Student> students = studentRepository.findAllBySchoolIdIn(ids);
        allSchools.forEach(school -> school.setStudentList(extractStudents(students, school.getId())));
        return allSchools;
    }

    private List<Student> extractStudents(List<Student> students, long id) {
        return students.stream()
                .filter(student -> student.getSchoolId() == id)
                .collect(Collectors.toList());
    }

    public List<School> getSchools(int page, Sort.Direction sort) {
        return schoolRepository.findAllSchools(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    public School getSingleSchool(long id) {
        return schoolRepository.findById(id)
                .orElseThrow();
    }
}
