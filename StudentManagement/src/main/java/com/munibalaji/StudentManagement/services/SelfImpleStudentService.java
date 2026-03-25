package com.munibalaji.StudentManagement.services;


import com.munibalaji.StudentManagement.dtos.StudentRequestDto;
import com.munibalaji.StudentManagement.dtos.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AnotherFakeStudentService")
public class SelfImpleStudentService implements StudentService{



    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {
        return null;
    }

    @Override
    public StudentResponseDto getStudentById(Long id) {
        System.out.println("Returning from another fake student");
        return null;
    }

    @Override
    public StudentResponseDto updateStudentById(Long id, StudentRequestDto studentRequestDto) {
        return null;
    }

    public List<StudentResponseDto> getAllStudents(){
        return null;
    }

    @Override
    public StudentResponseDto deleteStudentById(Long id) {
        return null;
    }

}
