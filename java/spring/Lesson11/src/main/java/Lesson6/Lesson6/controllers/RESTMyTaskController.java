package Lesson6.Lesson6.controllers;

import Lesson6.Lesson6.models.MyTask;
import Lesson6.Lesson6.services.MyTaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class RESTMyTaskController {

    private MyTaskService myTaskService;

    @GetMapping
    public ResponseEntity<List<MyTask>> getAllMyTasks() {
        return new ResponseEntity<>(myTaskService.getAllMyTask(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MyTask> createProduct(@RequestBody MyTask myTask) {
        return new ResponseEntity<>(myTaskService.createMyTask(myTask), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MyTask> getProduct(@PathVariable("id") Long id) {
        MyTask myTaskById;
        try {
            myTaskById = myTaskService.getMyTasksById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyTask());
        }
        return new ResponseEntity<>(myTaskById, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<MyTask> updateProduct(@RequestBody MyTask myTask) {
        return new ResponseEntity<>(myTaskService.updateMyTask(myTask), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        myTaskService.deleteMyTask(id);
        return ResponseEntity.ok().build();
    }
}

