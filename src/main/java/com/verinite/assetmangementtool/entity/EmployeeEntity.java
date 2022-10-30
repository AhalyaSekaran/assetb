package com.verinite.assetmangementtool.entity;


import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_employee")
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @Column(name="emp_id")
    private String empId;

    private String firstName;

    private String lastName;

    private String role;

    private String mail;

    private String mobile;

    private String location;

    private String status;

    private String department;

    private String designation;
}