package com.munibalaji.StudentManagement.Services;

import com.munibalaji.StudentManagement.mappers.StudentMapper;
import com.munibalaji.StudentManagement.thirdparty_dtos.FakeStudentDto;
import com.munibalaji.StudentManagement.dtos.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service("FakeStudentService")
public class FakeStudentService implements StudentService{


//    private static final String BASE_URL = "http://localhost:8080/students";
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    private static final String GET_STUDENT = BASE_URL + "/{id}";
    private static final String CREATE_STUDENT = BASE_URL;
    private static final String GET_ALL_STUDENTS = BASE_URL;
    private static final String UPDATE_STUDENT = BASE_URL+ "/{id}";
    private static final String DELETE_STUDENT = BASE_URL + "/{id}";

    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    public FakeStudentService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }


    @Override
    public StudentDto createStudent(StudentDto student){

        RestTemplate restTemplate = restTemplateBuilder.build();

        FakeStudentDto request = StudentMapper.StudentDtoToFakeStudentDto(student);

        // After Using mapper class I reduced repeated code
//        FakeStudentDto request = new FakeStudentDto();
//        request.setId(student.getId());
//        request.setName(student.getName());
//        request.setEmail(student.getEmail());
//        request.setCourse(student.getCourse());
//        request.setAge(student.getAge());


        ResponseEntity <FakeStudentDto> response = restTemplate.postForEntity(
                CREATE_STUDENT,
                request,
                FakeStudentDto.class
        );
        FakeStudentDto fakeStudentDto = response.getBody();
        return StudentMapper.FakeStudentDtoToStudentDto(fakeStudentDto);

    }

    @Override
    public StudentDto getStudentById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStudentDto> response = restTemplate.getForEntity(
                GET_STUDENT,
                FakeStudentDto.class,
                id);
        FakeStudentDto fakeStudentDto = response.getBody();

        if (fakeStudentDto == null){
            return new FakeStudentDto();
        }

        return StudentMapper.FakeStudentDtoToStudentDto(fakeStudentDto);
    }

    public StudentDto updateStudentById(Long id, StudentDto studentDto){
        RestTemplate restTemplate = restTemplateBuilder.build();

        //  Converting our DTO to External DTO
        FakeStudentDto request = StudentMapper.StudentDtoToFakeStudentDto(studentDto);

        // After using Student mapper class I reduced repeated code
//        FakeStudentDto request = new FakeStudentDto();
//        request.setId(studentDto.getId());
//        request.setName(studentDto.getName());
//        request.setEmail(studentDto.getEmail());
//        request.setCourse(studentDto.getCourse());
//        request.setAge(studentDto.getAge());

        ResponseEntity<FakeStudentDto> response = restTemplate.exchange(
                UPDATE_STUDENT,
                HttpMethod.PUT,
                new HttpEntity<>(request),
                FakeStudentDto.class,
                id);

            // Converting External DTO to our DTO
        FakeStudentDto updatedStudent  = response.getBody();


        // After modification
//        StudentDto result = new StudentDto();
//        result.setId(fakeResponse.getId());
//        result.setName(fakeResponse.getName());
//        result.setEmail(fakeResponse.getEmail());
//        result.setCourse(fakeResponse.getCourse());
//        result.setAge(fakeResponse.getAge());

        return StudentMapper.FakeStudentDtoToStudentDto(updatedStudent);
    }

    @Override
    public List<StudentDto> getAllStudents() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStudentDto[]> response = restTemplate.getForEntity(
                GET_ALL_STUDENTS,
                FakeStudentDto[].class);

        FakeStudentDto[] fakeStudentDtos = response.getBody();

//        return Arrays.asList(fakeStudentDtos);

        return Arrays.stream(fakeStudentDtos)
                .map(StudentMapper::FakeStudentDtoToStudentDto)
                .toList();
    }

    @Override
    public StudentDto deleteStudentById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStudentDto> response = restTemplate.exchange(
                DELETE_STUDENT,
                HttpMethod.DELETE,
                null,
                FakeStudentDto.class,
                id);

        FakeStudentDto fakeStudentDto = response.getBody();
        return StudentMapper.FakeStudentDtoToStudentDto(fakeStudentDto);
    }
}
