package springmvc.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import springmvc.web.config.ZJAppConfig;
import springmvc.web.config.ZJRootConfig;

public class ZJWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ZJRootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { ZJAppConfig.class };
	}

	// 获取DispatcherServlet的映射信息
	// 拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
	// jsp页面是tomcat的jsp引擎解析的；
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
