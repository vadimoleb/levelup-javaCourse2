package org.levelup.bank.system.config;

import lombok.Getter;
import lombok.Setter;

@Setter
public class DatabaseConfiguration {

    private static final DatabaseConfiguration INSTANCE = new DatabaseConfiguration();

    @Property("database.url")
    private String url;
    @Property("database.username")
    private String username;
    @Property("database.password")
    private String password;

    @Setter
    @Getter
    private String schemaManagement = "validate";

    private DatabaseConfiguration() {
    }

    public static DatabaseConfiguration getInstance() {
        return INSTANCE;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
