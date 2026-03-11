package com.munibalaji.StudentManagement.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto{

    private long id;
    private String name;
    private String email;
    private String course;
    private int age;

}
