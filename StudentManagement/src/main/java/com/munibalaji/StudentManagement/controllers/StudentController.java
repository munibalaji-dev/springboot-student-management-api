package com.munibalaji.StudentManagement.controllers;

import com.munibalaji.StudentManagement.Services.StudentService;
import com.munibalaji.StudentManagement.dtos.StudentDto;
import com.munibalaji.StudentManagement.exceptions.NotFoundException;
import com.munibalaji.StudentManagement.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    private StudentService studentService;

    @Autowired
    public StudentController (@Qualifier("FakeStudentService") StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) throws NotFoundException{
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable("id") Long id, @RequestBody StudentDto studentDto){
        StudentDto updatedStudent = studentService.updateStudentById(id, studentDto);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto> deleteStudentById(@PathVariable("id") Long id){
        return new ResponseEntity<>(studentService.deleteStudentById(id),HttpStatus.OK);
    }

}
