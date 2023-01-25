package com.carlos.miwebbase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {


    @GetMapping("/")
    public String getInicio(){
        return "inicio";
    }
}
