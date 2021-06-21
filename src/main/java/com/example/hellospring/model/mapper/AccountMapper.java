package com.example.hellospring.model.mapper;

import com.example.hellospring.entity.Account;
import com.example.hellospring.model.dto.AccountDTO;

public class AccountMapper {
    public static AccountDTO accountDTO (Account account) {
        AccountDTO tmp = new AccountDTO();
        tmp.setUserName(account.getUserName());
        tmp.setPassword(account.getPassword());
        return tmp;
    }
}
