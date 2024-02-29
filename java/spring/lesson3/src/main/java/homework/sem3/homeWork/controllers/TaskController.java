package homework.sem3.homeWork.controllers;

import homework.sem3.homeWork.domain.User;
import homework.sem3.homeWork.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age)
    {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    @GetMapping("/calc")
    public double calculateAverageAge()
    {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
