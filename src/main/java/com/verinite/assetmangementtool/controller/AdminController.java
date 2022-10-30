package com.verinite.assetmangementtool.controller;


import com.verinite.assetmangementtool.dto.AdminLoginDto;
import com.verinite.assetmangementtool.entity.AdminRegistrationEntity;
import com.verinite.assetmangementtool.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/assetManager/v1/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    @Autowired
    AdminServiceImpl service;
    //private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    @PostMapping("/add/admin")
    public Object registerAdmin(@Valid @RequestBody AdminRegistrationEntity adminData)
    {
        //LOGGER.debug("inside method!!!: Register method",adminData.getFirstName(),adminData.getLastName());
        return  service.registerNewAdmin(adminData);
    }
    @GetMapping("/get/all")
    public List<AdminRegistrationEntity> getAll()
    {
        return service.getAll();
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> adminLogin(@RequestBody AdminLoginDto login)
//    {
//        //LOGGER.info("inside method!!!: login method", login.getEmpId());
//       return service.checkLogin(login);
//    }


}
