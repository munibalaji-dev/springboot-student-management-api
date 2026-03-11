package com.munibalaji.StudentManagement.Services;

import com.munibalaji.StudentManagement.dtos.StudentDto;
import com.munibalaji.StudentManagement.thirdparty_dtos.FakeStudentDto;

import java.util.List;


public interface StudentService {


    public StudentDto createStudent(StudentDto studentDto);

    public StudentDto getStudentById(Long id);

    public List<StudentDto> getAllStudents();

    public StudentDto updateStudentById(Long id, StudentDto studentDto);

    public StudentDto deleteStudentById(Long id);
}
