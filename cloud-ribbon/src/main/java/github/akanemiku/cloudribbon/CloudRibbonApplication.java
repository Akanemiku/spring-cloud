package github.akanemiku.cloudribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon负载均衡
 * 从注册中心获取可用的服务实例，然后会通过负载均衡机制为服务消费者选择调用哪一个服务实例，
 * 从而达到缓解网络压力和扩容的目的
 * 同时也具备容灾的作用，不会应为某一台实例故障而导致系统不可用
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudRibbonApplication.class, args);
    }

    /**
     * Ribbon必须添加
     * @param builder
     * @return
     */
    @Bean
    @LoadBalanced
    RestOperations restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
