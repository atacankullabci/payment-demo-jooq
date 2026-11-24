package com.atancankullabci.adapter.out;

import com.atancankullabci.adapter.out.persistence.jooq.tables.records.AccountsRecord;
import com.atancankullabci.domain.Account;
import com.atancankullabci.domain.Balance;
import com.atancankullabci.domain.Currency;

public class AccountMapper {

    public Account fromRecord(AccountsRecord accountsRecord) {
        return new Account(accountsRecord.getId(), new Balance(accountsRecord.getBalance(), Currency.fromCurrencyCode(accountsRecord.getCurrency())));
    }

}
