package bfsi.core.zealous_bank.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bfsi.core.zealous_bank.entities.Transaction;
import bfsi.core.zealous_bank.services.TransactionService;

@RestController
@RequestMapping("/transfer")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping("/")
    public Transaction saving(@RequestBody Transaction transaction){
        try{
            return service.logTransaction(transaction);
        }
        catch(RuntimeException runtimeException){
            throw runtimeException;
        }
    }
}
