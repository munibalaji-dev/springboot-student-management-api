package com.munibalaji.StudentManagement.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends BaseModel{

    private String name;
    private String email;
    private int course;
    private int age;

}
