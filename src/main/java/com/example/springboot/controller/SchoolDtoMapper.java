package com.example.springboot.controller;

import com.example.springboot.controller.dto.SchoolDto;
import com.example.springboot.model.School;

import java.util.List;
import java.util.stream.Collectors;

public class SchoolDtoMapper {

    private SchoolDtoMapper(){}
    public static  List<SchoolDto> mapToSchoolDtos(List<School> schools) {
        return schools.stream()
                .map(school-> mapToSchoolDto(school))
                .collect(Collectors.toList());
    }

    public static SchoolDto mapToSchoolDto(School school){
        return SchoolDto.builder()
                .id(school.getId())
                .Name(school.getName())
                .build();
    }
}
