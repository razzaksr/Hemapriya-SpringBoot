package middleware.spring.backend_api_basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicApi {

    @PostMapping("/interview")
    public String checkSkill(@RequestBody String skill){
        if(skill.equalsIgnoreCase("git"))
            return "You are recruited";
        else
            return "Update your skill set";
    }

    @GetMapping("/bmi/{height}/{weight}")
    public String bmiCalculator(@PathVariable("height") double height,@PathVariable("weight") double weight){
        height=height/100;
        height=height*height;
        double bmi = weight/height;
        if(bmi<16)
            return "You are Severe Thinness";
        else if(bmi>=16&&bmi<17)
            return "You are Moderate Thinness";
        else if(bmi>=17&&bmi<18.5)
            return "You are Mild Thinness";
        else if(bmi>=18.5&&bmi<25)
            return "You are Normal";
        else if(bmi>=25&&bmi<30)
            return "You are Overweight";
        else
            return "You are Obese";
    }

    // pass some data via request paramter/ url
    @GetMapping("/dtr/{dollar}")// dollar is placeholder for user value
    public String dollarToRupees(@PathVariable("dollar") int dollar){
        return "Indian Ruppes "+(dollar*84.07)+" for "+dollar;
    }

    @GetMapping("/")// endpoint>> localhost:8080/hi
    public void freeze(){
        System.out.println("Welcome to the controller");
    }
    @GetMapping("/hi")// endpoint>> localhost:8080/hi
    public void freeze1(){
        System.out.println("Welcome to the Spring boot web");
    }
    @GetMapping("/bye")// endpoint>> localhost:8080/bye
    public String freeze3(){
        return "Happy coding!!!!!!!!!!!!!";
    }
    @GetMapping("/addition")// endpoint>> localhost:8080/addition
    public int freeze4(){
        return 20+10;
    }
}
