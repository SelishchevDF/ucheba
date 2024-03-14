package lesson7.lesson7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lesson7.lesson7.service.PrivateDataService;
import lesson7.lesson7.service.HomeService;
import lesson7.lesson7.service.PublicDataService;

@Controller
public class HomeController {

    private final HomeService homeService;
    private final PublicDataService publicDataService;
    private final PrivateDataService privateDataService;

    public HomeController(HomeService homeService, PublicDataService publicDataService, PrivateDataService privateDataService) {
        this.homeService = homeService;
        this.publicDataService = publicDataService;
        this.privateDataService = privateDataService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("text", homeService.getText());
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/public-data")
    public String user(Model model) {
        model.addAttribute("text", publicDataService.getText());
        return "public-data";
    }

    @GetMapping("/private-data")
    public String admin(Model model) {
        model.addAttribute("text", privateDataService.getText());
        return "private-data";
    }
}
