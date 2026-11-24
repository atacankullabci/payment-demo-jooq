package com.atancankullabci.service.port.in;


import com.atancankullabci.domain.Account;
import com.atancankullabci.domain.Money;
import com.atancankullabci.domain.MoneyTransfer;

import java.util.UUID;

public interface MoneyTransferService {
    MoneyTransfer transfer(Money money, Account from, Account to, UUID transferId);
}
