package github.akanemiku.cloudzuulgateway.filter;

import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常过滤器实现类
 */
@Component
public class ZuulErrorFilter extends SendErrorFilter {

	@Override
	public Object run() {
		String msg="请求失败！";
		//重写 run方法
		try{
			RequestContext ctx = RequestContext.getCurrentContext();
			//直接复用异常处理类
			ExceptionHolder exception = findZuulException(ctx.getThrowable());
			System.out.println("错误信息:"+exception.getErrorCause());
			msg+="error:"+exception.getErrorCause();
			System.out.println("msg:"+msg);

			HttpServletResponse response = ctx.getResponse();
			//设置编码
			response.setCharacterEncoding("UTF-8");
			response.getOutputStream().write(msg.getBytes());
		}catch (Exception ex) {
			ex.printStackTrace();
			ReflectionUtils.rethrowRuntimeException(ex);
		}
		return msg;
	}

	/**
	 *  自定义异常过滤器
	 */
	@Bean
	//@ConditionalOnProperty(name="zuul.SendErrorFilter.error.disable")
	public ZuulErrorFilter errorFilter() {
	    return new ZuulErrorFilter();
	}


}
