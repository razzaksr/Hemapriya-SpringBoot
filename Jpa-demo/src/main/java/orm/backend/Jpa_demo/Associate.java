package orm.backend.Jpa_demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Associate {
    // dependency injection
    @Autowired
    Manager manager;

    @GetMapping("/{model}")
    public Optional<Laptop> readByPrimaryKey(@PathVariable("model") String model){
        return manager.findById(model);
    }

    // create a record/ update record by passing whole proeprty with value
    @PostMapping("/")
    public Laptop createRecord(@RequestBody Laptop laptop){
        manager.save(laptop);
        return laptop;
    }

    // read
    @GetMapping("/")
    public List<Laptop> readingAll(){
        return (List<Laptop>) manager.findAll();
    }
}
