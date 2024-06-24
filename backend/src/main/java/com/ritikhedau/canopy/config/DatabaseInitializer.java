package com.ritikhedau.canopy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            
            System.out.println("Initializing public schema tables for Canopy...");

            statement.execute("CREATE TABLE IF NOT EXISTS public.tenants (" +
                    "id BIGSERIAL PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "slug VARCHAR(255) NOT NULL UNIQUE, " +
                    "schema_name VARCHAR(255) NOT NULL UNIQUE, " +
                    "plan VARCHAR(50) NOT NULL, " +
                    "status VARCHAR(50) NOT NULL, " +
                    "created_at TIMESTAMP, " +
                    "updated_at TIMESTAMP" +
                    ")");

            statement.execute("CREATE TABLE IF NOT EXISTS public.users (" +
                    "id BIGSERIAL PRIMARY KEY, " +
                    "email VARCHAR(255) NOT NULL UNIQUE, " +
                    "password VARCHAR(255) NOT NULL, " +
                    "first_name VARCHAR(255) NOT NULL, " +
                    "last_name VARCHAR(255) NOT NULL, " +
                    "tenant_id BIGINT, " +
                    "role VARCHAR(50) NOT NULL, " +
                    "status VARCHAR(50) NOT NULL, " +
                    "is_super_admin BOOLEAN DEFAULT FALSE, " +
                    "created_at TIMESTAMP, " +
                    "updated_at TIMESTAMP" +
                    ")");

            statement.execute("CREATE TABLE IF NOT EXISTS public.plans (" +
                    "id BIGSERIAL PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL UNIQUE, " +
                    "max_users INTEGER NOT NULL, " +
                    "max_teams INTEGER NOT NULL, " +
                    "max_api_calls_per_day INTEGER NOT NULL, " +
                    "features TEXT, " +
                    "price_monthly DECIMAL(10,2) NOT NULL, " +
                    "is_active BOOLEAN DEFAULT TRUE" +
                    ")");

            statement.execute("CREATE TABLE IF NOT EXISTS public.invitations (" +
                    "id BIGSERIAL PRIMARY KEY, " +
                    "email VARCHAR(255) NOT NULL, " +
                    "tenant_id BIGINT NOT NULL, " +
                    "role VARCHAR(50) NOT NULL, " +
                    "token VARCHAR(255) NOT NULL UNIQUE, " +
                    "status VARCHAR(50) NOT NULL, " +
                    "expires_at TIMESTAMP NOT NULL, " +
                    "created_at TIMESTAMP" +
                    ")");

            statement.execute("CREATE TABLE IF NOT EXISTS public.usage_records (" +
                    "id BIGSERIAL PRIMARY KEY, " +
                    "tenant_id BIGINT NOT NULL, " +
                    "metric VARCHAR(255) NOT NULL, " +
                    "count BIGINT NOT NULL DEFAULT 0, " +
                    "period VARCHAR(255) NOT NULL, " +
                    "recorded_at TIMESTAMP" +
                    ")");

            statement.execute("CREATE TABLE IF NOT EXISTS public.audit_logs (" +
                    "id BIGSERIAL PRIMARY KEY, " +
                    "tenant_id BIGINT, " +
                    "user_id BIGINT, " +
                    "user_email VARCHAR(255), " +
                    "action VARCHAR(255) NOT NULL, " +
                    "entity VARCHAR(255) NOT NULL, " +
                    "entity_id VARCHAR(255), " +
                    "details TEXT, " +
                    "timestamp TIMESTAMP NOT NULL" +
                    ")");
            
            System.out.println("Canopy public schema initialization complete!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
