package com.xib.assessment.controllers;

import com.xib.assessment.models.Manager;
import com.xib.assessment.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    @Autowired
    ManagerRepository managerRepository;

    @PostMapping("manager")
    public Manager createManager(@RequestBody Manager manager) {
        return managerRepository.saveAndFlush(manager);
    }
}
