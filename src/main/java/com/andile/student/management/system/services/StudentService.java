package com.andile.student.management.system.services;

import com.andile.student.management.system.exception.ResourceNotFoundException;
import com.andile.student.management.system.models.Student;
import com.andile.student.management.system.models.dto.MessageResponse;
import com.andile.student.management.system.models.dto.StudentRequest;
import com.andile.student.management.system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * This method is used to create a new Student record in the database with all the fields
     * @param request represents the student request object that will be sent to the server
     *
     * @return MessageResponse object with a message
     * */
    public MessageResponse create(StudentRequest request){
        //create a student object using the new keyword
        Student student = new Student();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAddress(request.getAddress());
        student.setMobile(request.getMobile());
        student.setEmail(request.getEmail());
        student.setRollNo(request.getRollNo());
        student.setAddendClass(request.getAttendClass());

        studentRepository.save(student);
        return  new MessageResponse ("New Student created successfully");
    }

    /**
     * This method is used to update a student using the studentId
     * @param studentId represents the studentId in the database
     * @param request represents the student request object that will be sent to the server
     * @throws ResourceNotFoundException when the student record is not found in the database
     **/
    public Optional<Student> update(Long studentId, StudentRequest request) throws ResourceNotFoundException{
        Optional<Student> student = studentRepository.findById(studentId);
        if (student != null){
            throw new ResourceNotFoundException("Student", "Id", studentId);
        } else
            student.get().setFirstName(request.getFirstName());
            student.get().setLastName(request.getLastName());
            student.get().setAddress(request.getAddress());
            student.get().setMobile(request.getMobile());
            student.get().setEmail(request.getEmail());
            student.get().setRollNo(request.getRollNo());
            student.get().setAddendClass(request.getAttendClass());
            studentRepository.save(student.get());// save the updated student object
        return student;
    }

    /**
     * This method is used to find a student by using the studentId
     * @param studentId represents the studentId in the database
     * @return Student object
     **/
    public Student findById(Long studentId) throws ResourceNotFoundException{
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "Id", studentId));
    }
    /**
     * This method is used to return a list of students that are in the database
     * @return List of student objects
     **/
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    /**
     * This method is used to delete a student record
     * @param studentId represents the studentId in the database
     * @throws ResourceNotFoundException when the student record is not found in the database
     **/
    public void delete(Long studentId) throws ResourceNotFoundException{

        if (studentRepository.getById(studentId).getId() == studentId){
            studentRepository.deleteById(studentId);
        } else{
            throw new ResourceNotFoundException("Student", "Id", studentId);
        }

    }

}
