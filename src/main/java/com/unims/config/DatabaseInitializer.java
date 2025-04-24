package com.unims.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Component
public class DatabaseInitializer {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @PostConstruct
    public void initializeDatabase() {
        String dbName = extractDatabaseName(datasourceUrl);
        String adminUrl = "jdbc:postgresql://localhost:5432/unims_db";

        try (Connection connection = DriverManager.getConnection(adminUrl, "uni_user", "postgres");
             Statement statement = connection.createStatement()) {

            String checkDbExistsQuery = "SELECT 1 FROM pg_database WHERE datname = '" + dbName + "'";
            var resultSet = statement.executeQuery(checkDbExistsQuery);

            if (!resultSet.next()) {
                String createDbQuery = "CREATE DATABASE " + dbName + " OWNER " + dbUsername;
                statement.executeUpdate(createDbQuery);
                System.out.println("База данных '" + dbName + "' успешно создана.");
            } else {
                System.out.println("База данных '" + dbName + "' уже существует.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка при инициализации базы данных: " + e.getMessage());
        }
    }

    private String extractDatabaseName(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }
}
