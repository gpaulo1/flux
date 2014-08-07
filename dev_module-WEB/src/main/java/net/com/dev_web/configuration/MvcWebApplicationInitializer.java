package net.com.dev_web.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class MvcWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer{

	protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SecurityConfig.class };
    }
	
}
