package github.akanemiku.cloudfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用Feign进行负载均衡及容错，Feign包含Ribbon及Hystrix
 *
 * name填写要转发服务的名字
 * ·cloud-eureka-service->yml->spring.application.name
 * fallback出错时调用类中，类中方法参数保持一致
 *
 * 当service宕掉后，自动使用Hystrix容错，调用相应方法
 * ·未开任何service情况下，调用本模块HelloController接口，进入容错方法
 *
 * ------------------------------------------------------
 *
 * 自定义配置
 * /@FeignClient(configuration = FooConfiguration.class)
 * 会覆盖默认的配置值
 * FooConfiguration 可以配置 feign.Decoder，feign.Encoder和feign.Contract，注意不需要 @Configuration注解
 *
 */
@FeignClient(name = "eureka-service", fallback = HelloServiceHystrix.class)
public interface HelloService {

    /**
     * 与对应服务中的接口一致
     * ·cloud-eureka-service->controller
     * @param name
     * @return
     */
    @GetMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);

}
