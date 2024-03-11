package lesson5.l5.controllers;

import lesson5.l5.model.MyTask;
import lesson5.l5.model.TaskStatus;
import lesson5.l5.services.MyTaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static java.util.stream.Collectors.toList;

@Controller
@AllArgsConstructor
public class MyTaskController {

    private MyTaskService myTaskService;

    @GetMapping("/t5")
    public String getMyTasks(Model model){
        model.addAttribute("myTasks", myTaskService.getAllMyTask());
        return "mytasks";
    }

    @PostMapping("/t5")
    public String addMyTask(MyTask myTask, Model model){
        myTaskService.createMyTask(myTask);
        model.addAttribute("myTasks", myTaskService.getAllMyTask());
        return "mytasks";
    }

    @GetMapping("/t5/{status}")
    public String getTasksByStatus(@PathVariable TaskStatus status, Model model){
        model.addAttribute("myTasks", myTaskService.getMyTasksByStatus(status));
        return "mytasks";
    }
}
