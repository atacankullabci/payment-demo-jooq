create table accounts
(
    id       TEXT PRIMARY KEY,
    balance  NUMERIC(19, 2) NOT NULL CHECK (balance >= 0),
    currency CHAR(3)        NOT NULL
);

create table transfers
(
    id           TEXT PRIMARY KEY,
    from_account TEXT           NOT NULL REFERENCES accounts (id),
    to_account   TEXT           NOT NULL REFERENCES accounts (id),
    amount       NUMERIC(19, 2) NOT NULL CHECK (amount > 0),
    status       TEXT           NOT NULL,
    created_at   TIMESTAMPTZ    NOT NULL DEFAULT now(),
    CHECK (from_account <> to_account)
)