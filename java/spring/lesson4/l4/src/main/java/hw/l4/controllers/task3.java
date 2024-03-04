package hw.l4.controllers;

import hw.l4.model.Human;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/t3")
public class task3 {

    @GetMapping()
    public String myForm(){
        return "myForm";
    }

    @PostMapping()
    public String viewWhatInForm(Human h, Model model){
        model.addAttribute("h", h);
        return "myFormOut";
    }

}
