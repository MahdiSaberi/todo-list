package com.data.todolist.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

@Configuration
public class ConnectionFactoryConfiguration {

    @Bean
    public DatabaseClient databaseClient() {
        return DatabaseClient.create(connectionFactory());
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration config =
                PostgresqlConnectionConfiguration.builder()
                        .database("todo_db")
                        .password("9697")
                        .username("postgres")
                        .host("localhost")
                        .build();
        return new PostgresqlConnectionFactory(config);
    }
}
