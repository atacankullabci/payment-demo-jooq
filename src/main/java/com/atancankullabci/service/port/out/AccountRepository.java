package com.atancankullabci.service.port.out;

import com.atancankullabci.domain.Account;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> getAccount(String accountId);

    boolean updateAccount(Account account);

    void addAccount(Account account);
}
