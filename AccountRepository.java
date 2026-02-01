package com.bank.repository;

import com.bank.model.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    private static List<Account> accounts = new ArrayList<>();

    static {
        accounts.add(new Account(101, "Charan", 5000));
        accounts.add(new Account(102, "Lokesh", 10000));
    }

    public List<Account> findAll() {
        return accounts;
    }

    public Account findById(int id) {
        return accounts.stream()
                .filter(acc -> acc.getAccountId() == id)
                .findFirst()
                .orElse(null);
    }
}
