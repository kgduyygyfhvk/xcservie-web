package xyz.xcservice.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wuwenchao
 * @date 2019/12/17
 */
@SpringBootApplication
@EnableSwagger2
public class ServiceApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ServiceApp.class);
        app.run(args);
    }
}
