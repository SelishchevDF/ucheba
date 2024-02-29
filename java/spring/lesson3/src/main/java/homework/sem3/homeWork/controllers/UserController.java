package homework.sem3.homeWork.controllers;

import homework.sem3.homeWork.domain.User;
import homework.sem3.homeWork.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")//localhost:8080/users
public class UserController {


    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }



    //localhost:8080/users/param?name=qwer&age=30&email=zxcv
    @PostMapping("/param")
    public void userAddFromParam(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("email") String email)
    {
        service.processRegistration(name, age, email);
    }
}
