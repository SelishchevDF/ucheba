package lesson5.l5.controllers;


import lesson5.l5.model.MyTask;
import lesson5.l5.services.MyTaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/REST/t5")
@AllArgsConstructor
public class RESTMyTaskController {

    private MyTaskService myTaskService;

    @PutMapping("/{id}")
    public List<MyTask> updateTaskStatus(@PathVariable Long id, @RequestBody MyTask task){
        myTaskService.updateMyTaskTaskStatus(id, task);
        return myTaskService.getAllMyTask();
    }

    @DeleteMapping("/{id}")
    public List<MyTask> updateTaskStatus(@PathVariable Long id){
        myTaskService.deleteMyTask(id);
        return myTaskService.getAllMyTask();
    }

}
