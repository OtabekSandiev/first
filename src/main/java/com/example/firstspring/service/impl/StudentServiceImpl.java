package com.example.firstspring.service.impl;

import com.example.firstspring.dto.ResponseDto;
import com.example.firstspring.dto.StudentDto;
import com.example.firstspring.entity.Student;
import com.example.firstspring.repository.StudentRepository;
import com.example.firstspring.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public ResponseDto addStudent(StudentDto studentDto) {
       Student student = Student.builder()
               .age(studentDto.getAge())
               .birthDate(studentDto.getBirthDate())
               .course(studentDto.getCourse())
               .name(studentDto.getName())
               .id(studentDto.getId())
               .build();

       studentRepository.save(student);

       return ResponseDto.builder()
               .code(0)
               .success(true)
               .message("Successfull saved!")
               .build();

    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(s -> StudentDto.builder()
                        .age(s.getAge())
                        .birthDate(s.getBirthDate())
                        .course(s.getCourse())
                        .name(s.getName())
                        .id(s.getId())
                        .build())
                .collect(Collectors.toList());
    }


    @Override
    public ResponseDto updateStudent(StudentDto studentDto) {
//            for (StudentDto s : students) {
//                if (s.getId().equals(studentDto.getId())) {
//                    if (studentDto.getName() != null) s.setName(studentDto.getName());
//                    if (studentDto.getAge() != null) s.setAge(studentDto.getAge());
//                    if (studentDto.getCourse() != null) s.setCourse(studentDto.getCourse());
//                    if (studentDto.getBirthDate() != null) s.setBirthDate(studentDto.getBirthDate());
//
//                    return ResponseDto.builder()
//                            .code(0)
//                            .success(true)
//                            .message("Successfully update!")
//                            .build();
//                }
//            }


            return ResponseDto.builder()
                    .code(-1)
                    .success(false)
                    .message("Data not found!")
                    .build();
        }


        @Override
        public ResponseDto deleteStudent (Integer id){
//            CopyOnWriteArrayList<StudentDto> cw = new CopyOnWriteArrayList(students);
            boolean deleted = false;
//            for (StudentDto student : students) {
//                if (student.getId().equals(id)) {
//                    students.remove(student);
//                    return ResponseDto.builder()
//                            .code(0)
//                            .success(true)
//                            .message("Successfully update!")
//                            .build();
//                }
//            }

            return deleted ? ResponseDto.builder()
                    .code(0)
                    .success(true)
                    .message("Successfully deleted!")
                    .build()
                    :
                        ResponseDto.builder()
                                .code(-1)
                                .success(false)
                                .message("Data not found!")
                                .build();
        }
    }



