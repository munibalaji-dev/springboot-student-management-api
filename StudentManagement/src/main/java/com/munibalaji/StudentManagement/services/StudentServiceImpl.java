package com.munibalaji.StudentManagement.services;

import com.munibalaji.StudentManagement.dtos.StudentRequestDto;
import com.munibalaji.StudentManagement.dtos.StudentResponseDto;
import com.munibalaji.StudentManagement.mappers.StudentMapper;
import com.munibalaji.StudentManagement.models.Student;
import com.munibalaji.StudentManagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService{


//    private static final String BASE_URL = "http://localhost:8080/students";
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    private static final String GET_STUDENT = BASE_URL + "/{id}";
    private static final String CREATE_STUDENT = BASE_URL;
    private static final String GET_ALL_STUDENTS = BASE_URL;
    private static final String UPDATE_STUDENT = BASE_URL+ "/{id}";
    private static final String DELETE_STUDENT = BASE_URL + "/{id}";

    private RestTemplateBuilder restTemplateBuilder;
    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(RestTemplateBuilder restTemplateBuilder,
                              StudentRepository studentRepository){
        this.restTemplateBuilder = restTemplateBuilder;
        this.studentRepository = studentRepository;
    }


    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto){

        RestTemplate restTemplate = restTemplateBuilder.build();

        Student student = StudentMapper.studentRequestDtoToEntity(studentRequestDto);


        ResponseEntity <StudentResponseDto> response = restTemplate.postForEntity(
                CREATE_STUDENT,
                student,
                StudentResponseDto.class
        );
        StudentResponseDto res = response.getBody();

        if (res == null) {
            return new StudentResponseDto();
        }

        return res;

    }

    @Override
    public StudentResponseDto getStudentById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<StudentResponseDto> response = restTemplate.getForEntity(
                GET_STUDENT,
                StudentResponseDto.class,
                id);


        StudentResponseDto studentResponseDto = response.getBody();

        if (studentResponseDto == null){
            return new StudentResponseDto();
        }

        return studentResponseDto;
    }

    public StudentResponseDto updateStudentById(Long id, StudentRequestDto studentRequestDto){
        RestTemplate restTemplate = restTemplateBuilder.build();


        Student request = StudentMapper.studentRequestDtoToEntity(studentRequestDto);

        ResponseEntity<StudentResponseDto> response = restTemplate.exchange(
                UPDATE_STUDENT,
                HttpMethod.PUT,
                new HttpEntity<>(request),
                StudentResponseDto.class,
                id);


        StudentResponseDto updatedStudent  = response.getBody();

        return updatedStudent;
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<StudentResponseDto[]> response = restTemplate.getForEntity(
                GET_ALL_STUDENTS,
                StudentResponseDto[].class);

        StudentResponseDto[] studentResponseDtos = response.getBody();

        return Arrays.asList(studentResponseDtos);
    }

    @Override
    public StudentResponseDto deleteStudentById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<StudentResponseDto> response = restTemplate.exchange(
                DELETE_STUDENT,
                HttpMethod.DELETE,
                null,
                StudentResponseDto.class,
                id);

        StudentResponseDto studentResponseDto = response.getBody();
        return studentResponseDto;
    }
}
