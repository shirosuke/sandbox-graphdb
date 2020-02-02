package com.example.arangoexample.config;

import com.arangodb.ArangoDB.Builder;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableArangoRepositories(basePackages = { "com.example.arangoexample.dao" })
public class ArangoDbConfig implements ArangoConfiguration {
    static String dbname = "example-db";
    @Override
    public Builder arango() {
        Builder arango = new Builder()
                .host("127.0.0.1", 8529)
                .user("root")
                .password(null);
        return arango;
    }
    @Override
    public String database() {
        return dbname;
    }
}
