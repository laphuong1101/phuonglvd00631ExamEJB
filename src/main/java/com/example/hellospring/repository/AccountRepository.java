package com.example.hellospring.repository;

import com.example.hellospring.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    public Optional<Account> findByUserName(String userName);

}
