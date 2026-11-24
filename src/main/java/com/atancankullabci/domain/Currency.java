package com.atancankullabci.domain;

public enum Currency {
    TURKISH_LIRA("949"),
    AMERICAN_DOLLAR("840"),
    ;

    private final String currencyCode;

    Currency(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public static Currency fromCurrencyCode(String currencyCode) {
        for (Currency currency : Currency.values()) {
            if (currency.getCurrencyCode().equals(currencyCode)) {
                return currency;
            }
        }
        return null;
    }
}
