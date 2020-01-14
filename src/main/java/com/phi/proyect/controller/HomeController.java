package com.phi.proyect.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @RequestMapping("/index")
    public ModelAndView hello(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("holo", "holo");
        mav.setViewName("index");
        return mav;
    }
    
    @RequestMapping("/semaforosalertas")
    public ModelAndView hello2(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("holo", "holo");
        mav.setViewName("semaforosalertas");
        return mav;
    }
    

    @RequestMapping("/fault")
    public Map<String, Object> holo(){
        Map<String,Object> res = new HashMap<>(1);
        res.put("status", 201);
        return res;
    }
    
    
}
