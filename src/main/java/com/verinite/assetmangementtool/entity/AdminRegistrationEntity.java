package com.verinite.assetmangementtool.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@Entity
@Table(name = "tbl_admin")
public class AdminRegistrationEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long adminId;

    private String firstName;

    private String lastName;

    private String empId;

    @Email
    private String mail;
private String status;
    private String role;
    private String location;
    @Column(name = "password", nullable = false)
    private String password;
	private String otp;
    private String access;


}
