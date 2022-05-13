package com.example.springboot.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SchoolDto {
    private long id;
    private String Name;
}
