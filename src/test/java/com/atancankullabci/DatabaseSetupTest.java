package com.atancankullabci;


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

import static com.atancankullabci.jooq.Tables.ACCOUNTS;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DatabaseSetupTest {
    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:17-alpine")
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

            assertEquals(0, dsl.fetchCount(ACCOUNTS));
        }
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }
}
