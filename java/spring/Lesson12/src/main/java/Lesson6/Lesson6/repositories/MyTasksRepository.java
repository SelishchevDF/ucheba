package Lesson6.Lesson6.repositories;

import Lesson6.Lesson6.models.MyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyTasksRepository extends JpaRepository<MyTask, Long> {
}
