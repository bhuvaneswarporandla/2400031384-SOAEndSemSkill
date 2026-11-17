
package com.example.account_service;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private Map<Integer, Account> accounts = new HashMap<>();

    @PostMapping
    public String createAccount(@RequestBody Account account) {
        accounts.put(account.getId(), account);
        return "Account created successfully";
    }

    @GetMapping
    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable int id) {
        return accounts.get(id);
    }

    @PutMapping("/{id}")
    public String updateAccount(@PathVariable int id,
                                @RequestBody Account account) {
        account.setId(id);
        accounts.put(id, account);
        return "Account updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable int id) {
        accounts.remove(id);
        return "Account deleted successfully";
    }
}
