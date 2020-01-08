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

	// ��ȡDispatcherServlet��ӳ����Ϣ
	// �����������󣨰�����̬��Դ��xx.js,xx.png���������ǲ�����*.jsp��
	// jspҳ����tomcat��jsp��������ģ�
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
