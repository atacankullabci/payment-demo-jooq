package com.atancankullabci;

import com.atancankullabci.adapter.out.AccountMapper;
import com.atancankullabci.adapter.out.JOOQAccountRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


public final class JOOQAccountRepositoryTest extends AbstractDatabaseSetup {

    private final JOOQAccountRepository jooqAccountRepository;

    public JOOQAccountRepositoryTest() {
        jooqAccountRepository = new JOOQAccountRepository(context, new AccountMapper());
    }

    @Test
    public void shouldReturnEmptyWhenNoAccountFound() {
        assertEquals(Optional.empty(), jooqAccountRepository.getAccount("1"));
    }

    @AfterAll
    static void afterAll() throws SQLException {
        terminate();
    }
}
