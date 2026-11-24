package com.atancankullabci;


import com.atancankullabci.adapter.out.persistence.jooq.tables.Accounts;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest extends AbstractDatabaseSetup {

    @Test
    public void shouldCreateAccountsTable() {
        assertEquals(0, context.fetchCount(Accounts.ACCOUNTS));
    }

    @AfterAll
    static void afterAll() throws SQLException {
        terminate();
    }
}
