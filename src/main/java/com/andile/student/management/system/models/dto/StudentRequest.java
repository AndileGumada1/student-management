package com.andile.student.management.system.models.dto;

import com.andile.student.management.system.models.AttendClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is a Student request that will be
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String rollNo;
    private String address;
    private String mobile;
    private String email;
    private AttendClass attendClass;
}
