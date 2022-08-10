package com.example.firstspring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "course")
    private String course;
}