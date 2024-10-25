package core.spring.ioc_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("core.spring.ioc_di")
public class PojoContainer {
    @Bean("trainee1")
    public Trainee getTraineeOne(){
        Trainee trainee=new Trainee();
        trainee.setTraineeName("Madhavan");
        trainee.setTraineeExperience(0);
        trainee.setTraineeSkill("Python");
        return trainee;
    }
    @Bean("trainee2")
    public Trainee getTrainee(){
        Trainee trainee=new Trainee();
        trainee.setTraineeName("Hemapriya");
        trainee.setTraineeExperience(2);
        trainee.setTraineeSkill("Java");
        return trainee;
    }
}
