package com.atancankullabci.service;


import com.atancankullabci.domain.Account;
import com.atancankullabci.domain.Money;
import com.atancankullabci.domain.MoneyTransfer;
import com.atancankullabci.service.port.in.MoneyTransferService;

import java.util.UUID;

public class MoneyTransferServiceImpl implements MoneyTransferService {


    @Override
    public MoneyTransfer transfer(Money money, Account from, Account to, UUID transferId) {
        return null;
    }
}
