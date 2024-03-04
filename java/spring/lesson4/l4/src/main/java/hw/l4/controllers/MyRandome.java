package hw.l4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/rnd")
public class MyRandome {

    @GetMapping()
    public String rnd(Model model){
        int r = new Random().nextInt(101);
        model.addAttribute("r", r);
        return "rnd";
    }

}
