package com.avaldinger.customer.customerservice.resources;

import com.avaldinger.customer.customerservice.model.Account;
import com.avaldinger.customer.customerservice.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.avaldinger.customer.customerservice.model.Account;

@RestController()
@RequestMapping("/account")
public class AccountController {


    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping("/all")
    public List<Account> getAllAccount() {

        logger.info("All method");

        List<Account> accounts = accountRepository.findAll();

        return  accounts;
    }

    @RequestMapping("/hi")
    public String greetings2() {

        logger.info("Greetings");

        return "Hello";


    }

    @GetMapping("/{accountId}")
    public Optional<Account> getAccountById(@PathVariable int accountId) {

        Optional<Account> account = accountRepository.findById(accountId);


        return account;

    }

    @PostMapping("/addAccount")
    public Account addAccount(@RequestBody Account newAccount) {

        return accountRepository.save(newAccount);

    }

    @PutMapping("/update")
    public Account updateAccount(@RequestBody Account myAccount) {

        Account account = accountRepository.findById(myAccount.getId()).orElse(null);

        account.setFirstName(myAccount.getFirstName());
        account.setLastName(myAccount.getLastName());
        account.setOwnerType(myAccount.getOwnerType());

        return accountRepository.save(account);

    }

    @DeleteMapping("/{accountId}")
    public Account deleteAccount(@PathVariable int accountId) {

        Account account = accountRepository.findById(accountId).orElse(null);

        logger.info(account.getFirstName());

        // Portfolios entry has to be removed first

        accountRepository.delete(account);

        return account;

    }

}
