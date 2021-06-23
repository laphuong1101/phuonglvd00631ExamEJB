package com.example.hellospring.controller;

import com.example.hellospring.entity.AccLogin;
import com.example.hellospring.entity.Account;
import com.example.hellospring.entity.Credential;
import com.example.hellospring.model.dto.AccountDTO;
import com.example.hellospring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping()
    public AccountDTO create (@RequestBody Account account){
        return accountService.save(account);
    }

    @PostMapping("/login")
    public String login (@RequestBody AccLogin accLogin) {
        Credential credential = accountService.login(accLogin);
        return credential.getTokenKey();
    }

    @GetMapping("/get-user")
    public AccountDTO getUser(@RequestParam String token){
        return accountService.findAccountByToken(token);
    }

}
