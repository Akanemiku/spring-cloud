package github.akanemiku.cloudfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 除yml外配置Ribbon负载均衡策略
 * 新建配置类，在方法中指定策略
    @Configuration
    public class RibbonConfiguration{
        @Bean
        public IRule ribbonRule(){
            return new RandomRule();
        }
    }
 * 通过@RibbonClien注解指定服务
    RibbonClient(name="eureka-service", configuration=RibbonConfiguration.class)
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard//HystrixDashboard需要
@EnableCircuitBreaker//HystrixDashboard需要
public class CloudFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudFeignApplication.class, args);
    }

}
