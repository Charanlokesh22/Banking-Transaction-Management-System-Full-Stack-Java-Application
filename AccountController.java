package com.bank.controller;

import com.bank.model.Account;
import com.bank.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService service = new AccountService();

    @GetMapping
    public List<Account> getAccounts() {
        return service.getAllAccounts();
    }

    @PostMapping("/transfer")
    public String transfer(
            @RequestParam int fromId,
            @RequestParam int toId,
            @RequestParam double amount) {
        return service.transferMoney(fromId, toId, amount);
    }
}
