package core.spring.ioc_di;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class IocDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IocDiApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyContainer.class);
		Scanner myScanner = context.getBean(Scanner.class);// dependency injection
		// int alpha = myScanner.nextInt();
		// int beta = myScanner.nextInt();
		// System.out.println(alpha*beta);
		ArrayList myArrayList = context.getBean(ArrayList.class);
		myArrayList.add("Razak Mohamed S");myArrayList.add(32);
		myArrayList.add(true);
		myArrayList.forEach(System.out::println);
	}

}
