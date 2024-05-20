package com.example.jpademo.controller;

import com.example.jpademo.service.Breachservice;
import com.example.jpademo.service.BreachserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BreachController {
    @Autowired
    private BreachserviceImpl breachservice;
}
