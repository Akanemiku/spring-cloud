package github.akanemiku.cloudeurekaservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ribbon调用
 */
@RestController
public class ConsumerController {

    @Value("${server.port}")
    private String port;

    @GetMapping("hello")
    public String hello(@RequestParam(value = "name", defaultValue = "forwei") String name){
        return "Hello " + name + ", I am from port:" + port;
    }
}
