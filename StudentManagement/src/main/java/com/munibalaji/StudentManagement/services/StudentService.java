package com.munibalaji.StudentManagement.services;

import com.munibalaji.StudentManagement.dtos.StudentRequestDto;
import com.munibalaji.StudentManagement.dtos.StudentResponseDto;
import java.util.List;


public interface StudentService {


    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto);

    public StudentResponseDto getStudentById(Long id);

    public List<StudentResponseDto> getAllStudents();

    public StudentResponseDto updateStudentById(Long id, StudentRequestDto studentRequestDto);

    public StudentResponseDto deleteStudentById(Long id);
}
