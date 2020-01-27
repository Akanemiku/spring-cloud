package github.akanemiku.cloudeurekaservice2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consumer2Controller {

    @Value("${server.port}")
    private String port;

    @GetMapping("hello")
    public String hello(@RequestParam(value = "name", defaultValue = "forwei") String name){
        return "Hello " + name + ", I am from port:" + port;
    }
}
