package com.example.firstspring.service;

import com.example.firstspring.dto.ResponseDto;
import com.example.firstspring.dto.StudentDto;

import java.util.List;

public interface StudentService {

    ResponseDto addStudent (StudentDto studentDto);

    List<StudentDto> getAll();

    ResponseDto updateStudent(StudentDto studentDto);

    ResponseDto deleteStudent(Integer id);
}

//SOLID
/*
*S - Single responsibility
* O - Open closed principle
* L - Liskov substitution
* I - Interface aggregation
* D - Dependency inversion
* */
