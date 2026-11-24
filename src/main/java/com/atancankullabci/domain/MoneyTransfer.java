package com.atancankullabci.domain;

import java.util.UUID;

public record MoneyTransfer(UUID transferId, Status status) {
    public enum Status {
        NONE,
        SUCCESS,
        FAILED,
        REJECTED,
        PENDING,
        CANCELLED
    }
}
