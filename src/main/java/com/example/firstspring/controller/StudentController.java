package com.example.firstspring.controller;

import com.example.firstspring.dto.ResponseDto;
import com.example.firstspring.dto.StudentDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @PostMapping
    public ResponseDto addStudent(@RequestBody StudentDto studentDto){

    }

    @GetMapping
    public List<StudentDto> getStudents(){

    }

    //Patch - Put
    @PatchMapping
    public ResponseDto updateStudent(@RequestBody StudentDto studentDto) {

    }
}
