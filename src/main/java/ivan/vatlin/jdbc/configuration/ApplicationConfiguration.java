package ivan.vatlin.jdbc.configuration;

import ivan.vatlin.jdbc.properties.MySqlServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {

    @Value("${spring.datasource.driver-class-name1}")
    private String driverName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    private MySqlServerProperties mySqlServerProperties;

    // using .properties file configuration
    @Bean
    public DataSource getMySqlDataSource1() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }

    // using .yml file configuration
    @Bean
    @Primary
    public DataSource getMySqlDataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(mySqlServerProperties.getDriverClassName());
        dataSource.setUrl(mySqlServerProperties.getUrl());
        dataSource.setUsername(mySqlServerProperties.getUserName());
        dataSource.setPassword(mySqlServerProperties.getPassword());

        return dataSource;
    }
}
