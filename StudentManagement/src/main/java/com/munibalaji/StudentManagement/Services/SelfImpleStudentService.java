package com.munibalaji.StudentManagement.Services;

import com.munibalaji.StudentManagement.dtos.StudentDto;
import com.munibalaji.StudentManagement.thirdparty_dtos.FakeStudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AnotherFakeStudentService")
public class SelfImpleStudentService implements StudentService{



    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        return null;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        System.out.println("Returning from another fake student");
        return null;
    }

    @Override
    public StudentDto updateStudentById(Long id, StudentDto studentDto) {
        return null;
    }

    public List<StudentDto> getAllStudents(){
        return null;
    }

    @Override
    public StudentDto deleteStudentById(Long id) {
        return null;
    }

}
