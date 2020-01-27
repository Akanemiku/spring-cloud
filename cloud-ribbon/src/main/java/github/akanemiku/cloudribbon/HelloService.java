package github.akanemiku.cloudribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestOperations restTemplate;

    public String hello(String name){
        return restTemplate.getForObject("http://eureka-service/hello?name="+name, String.class);
    }

    public String error(String name){
        return "sorry, error";
    }
}

