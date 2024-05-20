package com.example.jpademo.service;

import com.example.jpademo.dao.BreachDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreachserviceImpl implements Breachservice{
    @Autowired
    private BreachDao dao;
}
