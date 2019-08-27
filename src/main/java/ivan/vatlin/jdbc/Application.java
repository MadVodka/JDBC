package ivan.vatlin.jdbc;

import ivan.vatlin.jdbc.demo.DemoApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class);
        DemoApp demoApp = applicationContext.getBean(DemoApp.class);
        demoApp.run();
    }
}
