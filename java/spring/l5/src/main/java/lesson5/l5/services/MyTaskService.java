package lesson5.l5.services;

import lesson5.l5.model.MyTask;
import lesson5.l5.model.TaskStatus;
import lesson5.l5.repository.MyTasksRepository;
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

    public MyTask updateMyTaskTaskStatus(Long id, MyTask myTaskDetails){
        Optional<MyTask> optionalMyTask = repository.findById(id);
        if (optionalMyTask.isPresent()) {
            MyTask myTask = optionalMyTask.get();
            myTask.setMyTaskStatus(myTaskDetails.getMyTaskStatus());
            return repository.save(myTask);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }

    public List<MyTask> getMyTasksByStatus(TaskStatus status){
        return repository.findAll().stream()
                .filter(t -> t.getMyTaskStatus().equals(status))
                .toList();
    }

}
