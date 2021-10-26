package com.andile.student.management.system.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This is a Student model to be persistent in the database
 **/
@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "rollno")
    private String rollNo;

    private String address;
    private String mobile;
    private String email;


    @Enumerated(EnumType.STRING)//to declare that its value should be converted
    private AttendClass addendClass;

}
