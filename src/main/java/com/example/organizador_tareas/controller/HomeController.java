package com.example.organizador_tareas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirigirALogin() {
        return "login";
    }
}
