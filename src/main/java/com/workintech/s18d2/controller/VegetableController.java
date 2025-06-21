package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vegetables")

public class VegetableController {

    private Map<Integer, Vegetable> vegetables;

    @PostConstruct
    public void init(){
        vegetables = new HashMap<>();
    }


}
