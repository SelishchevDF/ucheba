package homework.sem3.homeWork.services;

import homework.sem3.homeWork.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }


    //Метод processRegistration
    public void processRegistration(String name, int age, String email){

        User u = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(u);
        notificationService.notifyUser(u);

    }

}
