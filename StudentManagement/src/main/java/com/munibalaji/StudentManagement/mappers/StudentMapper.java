package com.munibalaji.StudentManagement.mappers;

import com.munibalaji.StudentManagement.dtos.StudentDto;
import com.munibalaji.StudentManagement.thirdparty_dtos.FakeStudentDto;

public class StudentMapper {

    public static StudentDto FakeStudentDtoToStudentDto(FakeStudentDto fakeStudentDto){

        if (fakeStudentDto == null){
            return null;
        }

        StudentDto studentDto = new StudentDto();
        studentDto.setId(fakeStudentDto.getId());
        studentDto.setName(fakeStudentDto.getName());
        studentDto.setCourse(fakeStudentDto.getCourse());
        studentDto.setEmail(fakeStudentDto.getEmail());
        studentDto.setAge(fakeStudentDto.getAge());

        return studentDto;
    }


    public static FakeStudentDto StudentDtoToFakeStudentDto(StudentDto studentDto){

        if (studentDto == null){
            return null;
        }

        FakeStudentDto fakeStudentDto = new FakeStudentDto();
        fakeStudentDto.setId(studentDto.getId());
        fakeStudentDto.setName(studentDto.getName());
        fakeStudentDto.setEmail(studentDto.getEmail());
        fakeStudentDto.setCourse(studentDto.getCourse());
        fakeStudentDto.setAge(studentDto.getAge());

        return fakeStudentDto;
    }
}
