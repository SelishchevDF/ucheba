package Lesson6.Lesson6;

import Lesson6.Lesson6.services.MyTaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Lesson6Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson6Application.class, args);
		var c = new AnnotationConfigApplicationContext(Lesson6Application.class);
		var service = c.getBean(MyTaskService.class);
	}

}
