package middleware.spring.backend_api_basic;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/savings")
public class SavingsApi {
    List<Savings> accounts = Stream.of(
        new Savings("Razak Mohamed S",8765678987L,259.6,"ABCD00001","ABC Bank"),
        new Savings("Zealous Tech Corp",765678987644L,12959.6,"ABCD00001","ABC Bank"),
        new Savings("Sabarinathan S",9876567894L,9446.6,"ABCD01041","BCD Bank")
    ).collect(Collectors.toList());

    @PostMapping("/")
    public String create(@RequestBody Savings savings){
        accounts.add(savings);
        return savings.getAccountHolder()+" has opened savings account";
    }

    @GetMapping("/")
    public List<Savings> readAll(){
        return accounts;
    }
}
