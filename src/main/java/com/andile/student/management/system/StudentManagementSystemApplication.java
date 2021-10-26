package com.andile.student.management.system;

import com.andile.student.management.system.models.AttendClass;
import com.andile.student.management.system.models.Student;
import com.andile.student.management.system.models.dto.StudentRequest;
import com.andile.student.management.system.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	/**
	 * using the commandLineRunner interface to populate the database
	 * */
	@Override
	public void run(String... args) throws Exception {

		StudentRequest studentRequest = new StudentRequest("Andile","Gumada","202","23793 Orange Street","0614723334","andile.gumada@xgileit.com", AttendClass.ATTEND_CLASS);
		studentService.create(studentRequest);

	}
}
