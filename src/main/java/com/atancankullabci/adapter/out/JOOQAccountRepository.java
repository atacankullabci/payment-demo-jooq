package com.atancankullabci.adapter.out;

import com.atancankullabci.domain.Account;
import com.atancankullabci.service.port.out.AccountRepository;

import java.util.Optional;

public class JOOQAccountRepository implements AccountRepository {



    @Override
    public Optional<Account> getAccount(String accountId) {
        return Optional.empty();
    }

    @Override
    public boolean updateAccount(Account account) {

        return true;
    }

    @Override
    public void addAccount(Account account) {

    }
}
