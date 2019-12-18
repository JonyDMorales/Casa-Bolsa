package com.phi.proyect.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @PostMapping("/hello")
    public Map<String, Object> hello(){
        Map<String,Object> res = new HashMap<>(1);
        res.put("status", 200);
        return res;
    }
}
