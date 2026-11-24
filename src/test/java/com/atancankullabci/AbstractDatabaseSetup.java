package com.atancankullabci;

import org.flywaydb.core.Flyway;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.testcontainers.postgresql.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDatabaseSetup {

    static final PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:17-alpine")
            .withUsername("postgres")
            .withPassword("postgres")
            .withDatabaseName("jooq_demo");

    protected static DSLContext context;
    protected static Connection connection;

    static {
        postgres.start();

        Flyway.configure()
                .dataSource(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword())
                .load()
                .migrate();

        try {
            connection = DriverManager.getConnection(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());
            context = DSL.using(connection, SQLDialect.POSTGRES);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void terminate() throws SQLException {
        if (connection != null) {connection.close();}

        postgres.stop();
    }
}
