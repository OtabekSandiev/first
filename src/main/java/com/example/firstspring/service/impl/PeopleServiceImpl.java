package com.example.firstspring.service.impl;

import com.example.firstspring.dto.ResponseDto;
import com.example.firstspring.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl {

    @Autowired
    private StudentDto studentDto;

    public ResponseDto<StudentDto> std (String name){
        studentDto.setName(name);
        return ResponseDto.<StudentDto>builder().message("Ok").success(true).data(studentDto).build();
    }
}
