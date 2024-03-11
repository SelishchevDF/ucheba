package Lesson6.Lesson6.services;

import Lesson6.Lesson6.models.MyTask;
import Lesson6.Lesson6.repositories.MyTasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MyTaskService {

    private MyTasksRepository repository;

    public List<MyTask> getAllMyTask(){
        return repository.findAll();
    }

    public MyTask createMyTask(MyTask myTask){
        return repository.save(myTask);
    }

    public void deleteMyTask(Long id){
        repository.deleteById(id);
    }

    public MyTask updateMyTask(MyTask myTaskDetails){
        MyTask myTasksById = getMyTasksById(myTaskDetails.getId());

        myTasksById.setTaskDescription(myTaskDetails.getTaskDescription());
        myTasksById.setTaskContent(myTaskDetails.getTaskContent());

        return repository.save(myTasksById);
    }

    public MyTask getMyTasksById(Long id){
        return repository.findById(id).orElseThrow(null);

    }

}
