package Lesson6.Lesson6.services;

import Lesson6.Lesson6.models.MyTask;
import Lesson6.Lesson6.repositories.MyTasksRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MyTaskServiceUnitTests {

    @Test
    @DisplayName("Test getting MyTask by id")
    public void myTaskServiceGetMyTasksByIdTest(){

        MyTasksRepository myTasksRepository = mock(MyTasksRepository.class);
        MyTaskService myTaskService = new MyTaskService(myTasksRepository);

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

}


