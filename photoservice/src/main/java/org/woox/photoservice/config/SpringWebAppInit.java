package org.woox.photoservice.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class SpringWebAppInit implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "CXFServlet";
	private static final String DISPATCHER_SERVLET_MAPPING_SERVICES = "/*";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringWebAppConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, CXFServlet.class);	
		dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING_SERVICES);
		dispatcher.setLoadOnStartup(1);
		
		
//		ServletRegistration.Dynamic jsonDispatcher = servletContext.addServlet("jsonDispatcher", new DispatcherServlet(rootContext));
//	    jsonDispatcher.setInitParameter("defaultMimeType", "application/json");
//	    jsonDispatcher.addMapping(DISPATCHER_SERVLET_MAPPING_SERVICES);
//	    jsonDispatcher.setLoadOnStartup(1);

	}

}