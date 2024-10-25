package core.spring.ioc_di;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("java.util")
public class MyContainer {
    @Bean
    public Scanner getScanner(){
        Scanner scanner=new Scanner(System.in);
        return scanner;
    }
    @Bean
    public ArrayList geArrayList(){
        ArrayList list=new ArrayList<>();
        return list;
    }
}
