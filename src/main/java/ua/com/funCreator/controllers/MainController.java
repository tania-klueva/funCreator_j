package ua.com.funCreator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String main(){
    return "index";
    }
    
    @GetMapping("/gallery")
    public String gallery(){
    return "gallery";
    }
    

    


    @GetMapping("/contacts")
    public String contacts(){
    return "contact";
    }
}
