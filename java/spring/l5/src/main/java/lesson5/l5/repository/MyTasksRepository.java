package lesson5.l5.repository;

import lesson5.l5.model.MyTask;
import lesson5.l5.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyTasksRepository extends JpaRepository<MyTask, Long> {
}
