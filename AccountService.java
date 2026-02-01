package com.bank.service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import java.util.List;

public class AccountService {

    private AccountRepository repository = new AccountRepository();

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public String transferMoney(int fromId, int toId, double amount) {
        Account from = repository.findById(fromId);
        Account to = repository.findById(toId);

        if (from == null || to == null) {
            return "Invalid account details";
        }

        if (from.getBalance() < amount) {
            return "Insufficient balance";
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        return "Transaction successful";
    }
}
