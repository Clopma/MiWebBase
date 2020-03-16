package com.example.miwebbase.Controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/inicio")
    public String showForm(Model model) {
        model.addAttribute("usuario", SecurityContextHolder.getContext().getAuthentication().getName());
        return "inicio";
    }

}
