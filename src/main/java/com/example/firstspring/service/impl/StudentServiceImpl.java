package com.example.firstspring.service.impl;

import com.example.firstspring.dto.ResponseDto;
import com.example.firstspring.dto.StudentDto;
import com.example.firstspring.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class StudentServiceImpl implements StudentService {

    public static ArrayList<StudentDto> students = new ArrayList<>();


    @Override
    public ResponseDto addStudent(StudentDto studentDto) {
        students.add(studentDto);

        return ResponseDto.builder()
                .code(0)
                .success(true)
                .message("Successfully saved!")
                .build();
    }

    @Override
    public List<StudentDto> getAll() {
        return students;
    }

    @Override
    public ResponseDto updateStudent(StudentDto studentDto) {
            for (StudentDto s : students) {
                if (s.getId().equals(studentDto.getId())) {
                    if (studentDto.getName() != null) s.setName(studentDto.getName());
                    if (studentDto.getAge() != null) s.setAge(studentDto.getAge());
                    if (studentDto.getCourse() != null) s.setCourse(studentDto.getCourse());
                    if (studentDto.getBirthDate() != null) s.setBirthDate(studentDto.getBirthDate());

                    return ResponseDto.builder()
                            .code(0)
                            .success(true)
                            .message("Successfully update!")
                            .build();
                }
            }


            return ResponseDto.builder()
                    .code(-1)
                    .success(false)
                    .message("Data not found!")
                    .build();
        }


        @Override
        public ResponseDto deleteStudent (Integer id){
            CopyOnWriteArrayList<StudentDto> cw = new CopyOnWriteArrayList(students);
            for (StudentDto student : students) {
                if (student.getId().equals(id)) {
                    students.remove(student);
                    return ResponseDto.builder()
                            .code(0)
                            .success(true)
                            .message("Successfully update!")
                            .build();
                }
            }
            return ResponseDto.builder()
                    .code(-1)
                    .success(false)
                    .message("Data not found!")
                    .build();
        }
    }



