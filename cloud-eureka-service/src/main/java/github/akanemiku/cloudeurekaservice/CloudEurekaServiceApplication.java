package github.akanemiku.cloudeurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServiceApplication.class, args);
    }

}
