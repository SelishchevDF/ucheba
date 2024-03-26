package Lesson6.Lesson6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapp")
public class MyController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello!!!!";
    }

}
