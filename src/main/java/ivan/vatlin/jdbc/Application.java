package ivan.vatlin.jdbc;

import ivan.vatlin.jdbc.demo.ActionsWithDatabaseDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class);
        ActionsWithDatabaseDemo actionsWithDatabaseDemo = applicationContext.getBean(ActionsWithDatabaseDemo.class);
        actionsWithDatabaseDemo.run();
    }
}
