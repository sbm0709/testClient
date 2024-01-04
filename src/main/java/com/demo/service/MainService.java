package com.demo.service;


import com.demo.mappers.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    MainMapper mainMapper;


}
