package middleware.spring.backend_api_basic;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/savings")
public class SavingsApi {
    // storage: temporary
    List<Savings> accounts = Stream.of(
        new Savings("Razak Mohamed S",8765678987L,259.6,"ABCD00001","ABC Bank"),
        new Savings("Zealous Tech Corp",765678987644L,12959.6,"ABCD00001","ABC Bank"),
        new Savings("Sabarinathan S",9876567894L,9446.6,"ABCD01041","BCD Bank"),
        new Savings("Rasheedha R",1121323233434L,1446.6,"BCD010241","BCD Bank"),
        new Savings("Rajiya R",949349345443434L,13446.6,"BCD010241","ABC Bank")
    ).collect(Collectors.toList());

    @PutMapping("/fine")
    public void penalty(){
        for(int index=0;index<accounts.size();index++){
            if(accounts.get(index).getAccountBalance()<5000)
                accounts.get(index).setAccountBalance
                (accounts.get(index).getAccountBalance()-50);
        }
    }

    @DeleteMapping("/bynum/{accnum}")
    public String deletionByAccountNumber(@PathVariable("accnum") long accnum){
        int oldSize = accounts.size();
        accounts=accounts.stream().filter(obj->obj.getAccountNumber()!=accnum).toList();
        int newSize = accounts.size();
        if(oldSize==newSize)
            return accnum+" is invalid";
        else
            return accnum+" has suspended";
    }

    @DeleteMapping("/{index}")
    public String deletionByPosition(@PathVariable("index") int index){
        if(index>=0&&index<accounts.size()){
            accounts.remove(index);
            return "Account has suspended";
        }
        return "Invalid account";
    }

    // update
    @PutMapping("/")
    public String updateAccount(@RequestBody Savings acc){
        for(int index=0;index<accounts.size();index++){
            // find the index of matched account number from storage
            if(accounts.get(index).getAccountNumber()==acc.getAccountNumber()){
                // update the matched account details
                accounts.set(index, acc);
                return acc.getAccountNumber()+" has updated";
            }
        }
        return acc.getAccountNumber()+" hasn't updated";
    }

    // read by account number
    @GetMapping("/accnum/{number}")
    public Savings readByAccountNumber(@PathVariable("number") long number){
        try{
            return accounts.stream().filter(obj-> obj.getAccountNumber()==number).toList().get(0);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            return null;
        }
    }

    // read one pojo by position
    @GetMapping("/{index}")
    public Savings readByIndex(@PathVariable("index") int index){
        if(index>=0&&index<accounts.size()){
            return accounts.get(index);
        }
        return null;
    }

    // create
    @PostMapping("/")
    public String create(@RequestBody Savings savings){
        accounts.add(savings);
        return savings.getAccountHolder()+" has opened savings account";
    }

    // read existing 
    @GetMapping("/")
    public List<Savings> readAll(){
        return accounts;
    }
}
