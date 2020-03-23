package com.plateer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Configuration
public class DB {

    private DataSource dataSource;

    public DB(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public String getDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.error(connection.getMetaData().getDriverName());
        return "Good";
    }
}
