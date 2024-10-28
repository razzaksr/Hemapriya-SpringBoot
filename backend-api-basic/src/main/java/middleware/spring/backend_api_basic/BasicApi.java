package middleware.spring.backend_api_basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicApi {
    @GetMapping("/")// endpoint>> localhost:8080/hi
    public void freeze(){
        System.out.println("Welcome to the controller");
    }
    @GetMapping("/hi")// endpoint>> localhost:8080/hi
    public void freeze1(){
        System.out.println("Welcome to the Spring boot web");
    }
    @GetMapping("/bye")// endpoint>> localhost:8080/hi
    public String freeze3(){
        return "Happy coding!!!!!!!!!!!!!";
    }
    @GetMapping("/addition")// endpoint>> localhost:8080/hi
    public int freeze4(){
        return 20+10;
    }
}
