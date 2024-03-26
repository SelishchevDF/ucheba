package Lesson6.Lesson6.services;

import Lesson6.Lesson6.models.MyTask;
import Lesson6.Lesson6.repositories.MyTasksRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MyTaskServiceWithAnnotationsUnitTests {

    @Mock
    private MyTasksRepository myTasksRepository;

    @InjectMocks
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

        //Java HotSpot(TM) 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
        //
        //java.lang.IllegalStateException: Значение отсутствует
    }



}