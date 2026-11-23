create table accounts
(
    id       VARCHAR(256) PRIMARY KEY,
    balance  NUMERIC(19, 2) NOT NULL CHECK (balance >= 0),
    currency CHAR(3)        NOT NULL
);

create table transfers
(
    id           VARCHAR(256) PRIMARY KEY,
    from_account VARCHAR(256)           NOT NULL REFERENCES accounts (id),
    to_account   VARCHAR(256)           NOT NULL REFERENCES accounts (id),
    amount       NUMERIC(19, 2) NOT NULL CHECK (amount > 0),
    status       VARCHAR(50)           NOT NULL,
    created_at   TIMESTAMPTZ    NOT NULL DEFAULT now(),
    CHECK (from_account <> to_account)
);