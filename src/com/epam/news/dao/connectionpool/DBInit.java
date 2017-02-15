package com.epam.news.dao.connectionpool;

import java.util.ResourceBundle;

public class DBInit {
    final ResourceBundle RESOURCE;
    final String DATABASE;
    final String DB_LOGIN;
    final int POOL_SIZE;
    final String DB_PASSWORD;

    DBInit() {
        try {
            RESOURCE = ResourceBundle.getBundle("db.database");
            DATABASE = RESOURCE.getString("db.url");
            DB_LOGIN = RESOURCE.getString("db.user");
            POOL_SIZE = Integer.valueOf(RESOURCE.getString("db.poolsize"));
            DB_PASSWORD = RESOURCE.getString("db.password");
        } catch (NumberFormatException e) {
            throw new RuntimeException("Database can't been initialised.", e);
        }
    }
}
