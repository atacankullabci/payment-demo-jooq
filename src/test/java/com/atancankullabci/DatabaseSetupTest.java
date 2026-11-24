package com.atancankullabci;


import com.atancankullabci.adapter.out.persistence.jooq.tables.Accounts;
import org.flywaydb.core.Flyway;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.postgresql.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DatabaseSetupTest {
    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:17-alpine")
            .withUsername("postgres")
            .withPassword("postgres")
            .withDatabaseName("jooq_demo");

    @BeforeAll
    public static void beforeAll() {
        postgres.start();

        Flyway.configure()
                .dataSource(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword())
                .load()
                .migrate();
    }

    @Test
    public void shouldCreateAccountsTable() throws SQLException {
        try (Connection connection = DriverManager.getConnection(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword())) {
            DSLContext dsl = DSL.using(connection, SQLDialect.POSTGRES);

            assertEquals(0, dsl.fetchCount(Accounts.ACCOUNTS));
        }
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }
}
