package github.akanemiku.cloudribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * 使用Ribbon进行负载均衡
 * Hystrix容错
 */
@Service
public class HelloService {

    @Autowired
    RestOperations restTemplate;

    /**
     * 转发名称相同的服务
     * ·cloud-eureka-service->yml->spring.application.name
     * ·在服务中要有对应接口，如cloud-eureka-service->controller中存在/hello接口
     *
     * 使用HystrixCommand设置出错时调用的方法，参数一致
     *
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "error")
    public String hello(String name){
        return restTemplate.getForObject("http://eureka-service/hello?name="+name, String.class);
    }

    public String error(String name){
        return "sorry, error";
    }
}

