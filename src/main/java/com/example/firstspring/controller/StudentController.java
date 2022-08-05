package com.example.firstspring.controller;

import com.example.firstspring.dto.ResponseDto;
import com.example.firstspring.dto.StudentDto;
import com.example.firstspring.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Hello
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImpl studentService;


    public StudentController(StudentServiceImpl studentService){
        this.studentService=studentService;
    }


    @PostMapping
    public ResponseDto addStudent(@RequestBody StudentDto studentDto){
        return studentService.addStudent(studentDto);
    }

    @GetMapping
    public List<StudentDto> getStudents(){
        return studentService.getAll();
    }


    //Patch - Put
    @PatchMapping
    //UpdateStudent
    public ResponseDto updateStudent(@RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }

}
