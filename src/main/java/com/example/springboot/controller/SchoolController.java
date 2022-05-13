package com.example.springboot.controller;

import com.example.springboot.controller.dto.SchoolDto;
import com.example.springboot.model.School;
import com.example.springboot.model.Student;
import com.example.springboot.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/schools")
    public List<SchoolDto> getSchools(@RequestParam(required = false) Integer page, Sort.Direction sort) throws IllegalAccessException {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDiection = sort != null ? sort : Sort.Direction.ASC;
        return SchoolDtoMapper.mapToSchoolDtos(schoolService.getSchools(pageNumber,sortDiection));
    }

    @GetMapping("/schools/students")
    public List<School> getSchoolsWithStudent(@RequestParam(required = false) Integer page, Sort.Direction sort) throws IllegalAccessException {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDiection = sort != null ? sort : Sort.Direction.ASC;
        return schoolService.getSchoolsWithStudents(pageNumber, sortDiection);
    }


    @GetMapping("/schools/{id}")
    public School getSingleSchool(@PathVariable long id) throws IllegalAccessException {
        return schoolService.getSingleSchool(id);
    }
}
