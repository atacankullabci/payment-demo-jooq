package com.atancankullabci.adapter.out;

import com.atancankullabci.adapter.out.persistence.jooq.Tables;
import com.atancankullabci.adapter.out.persistence.jooq.tables.records.AccountsRecord;
import com.atancankullabci.domain.Account;
import com.atancankullabci.service.port.out.AccountRepository;
import org.jooq.DSLContext;

import java.util.Optional;


public class JOOQAccountRepository implements AccountRepository {

    private final DSLContext jooq;
    private final AccountMapper accountMapper;

    public JOOQAccountRepository(DSLContext jooq, AccountMapper accountMapper) {
        this.jooq = jooq;
        this.accountMapper = accountMapper;
    }

    @Override
    public Optional<Account> getAccount(String accountId) {
        Optional<AccountsRecord> accountsRecord = jooq
                .selectFrom(Tables.ACCOUNTS)
                .where(Tables.ACCOUNTS.ID.eq(accountId))
                .fetchOptional();
        return accountsRecord.map(accountMapper::fromRecord);
    }

    @Override
    public boolean updateAccount(Account account) {

        return true;
    }

    @Override
    public void addAccount(Account account) {

    }
}
