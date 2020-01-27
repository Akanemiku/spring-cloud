package github.akanemiku.cloudfeign;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrix implements HelloService {
    @Override
    public String hello(String name) {
        return "Feign, error!";
    }
}
