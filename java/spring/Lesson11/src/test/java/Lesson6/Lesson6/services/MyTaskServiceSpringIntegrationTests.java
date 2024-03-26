package Lesson6.Lesson6.services;

import Lesson6.Lesson6.models.MyTask;
import Lesson6.Lesson6.repositories.MyTasksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class MyTaskServiceSpringIntegrationTests {

    @MockBean
    private MyTasksRepository repository;

    @Autowired
    private MyTaskService myTaskService;

    @Test
    public void myTaskServiceGetMyTasksByIdTest(){
        MyTask myTask = new MyTask();
        myTask.setId(3L);
        myTask.setTaskDescription("qwert");
        myTask.setTaskContent("qwert");
        myTaskService.createMyTask(myTask);

        MyTask myTaskTest = myTaskService.getMyTasksById(3L);

        verify(myTaskTest.getId().equals(3L));
        verify(myTaskTest.getTaskDescription().equals("qwert"));
        verify(myTaskTest.getTaskContent().equals("qwert"));

        //java.lang.IllegalStateException: Значение отсутствует
    }

    @Test
    public void getAllMyTaskTest() {
        MyTask myTask = new MyTask();
        myTask.setTaskDescription("qwert");
        myTask.setTaskContent("qwert");
        myTaskService.createMyTask(myTask);

        verify(myTaskService.getAllMyTask().size() > 0);

        //org.mockito.exceptions.misusing.NotAMockException:
        //Argument passed to verify() is of type Boolean and is not a mock!
    }
}