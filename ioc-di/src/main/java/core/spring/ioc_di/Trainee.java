package core.spring.ioc_di;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // getter, setter, toString
@AllArgsConstructor // paramterized AllArgsConstructor
@NoArgsConstructor // default constructor
public class Trainee {
    private String traineeName;
    private String traineeSkill;
    private int traineeExperience;
}
