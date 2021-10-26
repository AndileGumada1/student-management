package com.andile.student.management.system.controller;

import com.andile.student.management.system.exception.ResourceNotFoundException;
import com.andile.student.management.system.models.Student;
import com.andile.student.management.system.models.dto.MessageResponse;
import com.andile.student.management.system.models.dto.StudentRequest;
import com.andile.student.management.system.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This is a controller class where we expose our end-points
 **/
@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * End-point used to retrieve a list of all the students
     * @return ResponseEntity
     **/
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents () {
        List<Student> studentList = studentService.findAll();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    /**
     * End-point used to create a new students
     * @return ResponseEntity
     **/
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> createNewStudent(@RequestBody StudentRequest request) {
        MessageResponse newEmployee = studentService.create(request);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    /**
     * End-point used to retrieve a student based on the ID
     * @return ResponseEntity
     * @throws ResourceNotFoundException when the student record is not found
     **/
    @GetMapping("/find/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Student student = studentService.findById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    /**
     * End-point used to delete a student based on the ID
     * @return ResponseEntity
     * @throws ResourceNotFoundException when the student record is not found
     **/
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) throws ResourceNotFoundException {
        studentService.delete(id);
        return new ResponseEntity<String>("Student is deleted successfully.!", HttpStatus.OK);
    }
    /**
     * End-point used to update a student based on the ID
     * @return ResponseEntity
     * @throws ResourceNotFoundException when the student record is not found
     **/
    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateStudent(@PathVariable Long id, @RequestBody StudentRequest request) throws ResourceNotFoundException {
        studentService.update(id, request);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
