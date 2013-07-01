package org.woox.photoservice;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.woox.photoservice.config.WebApplicationConfig;

public class WebApplicationInit implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "CXFServlet";
	private static final String DISPATCHER_SERVLET_MAPPING_SERVICES = "/rest/*";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(WebApplicationConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, CXFServlet.class);
		
		//jersey stuff
		//ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new ServletContainer());
		//dont use POJOMappingFeature!!
	    //dispatcher.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "false");

		dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING_SERVICES);
		dispatcher.setLoadOnStartup(1);

	}

}