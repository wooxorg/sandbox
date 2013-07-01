package org.woox.photoservice.config;

import java.util.Arrays;

import javax.ws.rs.ext.RuntimeDelegate;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.woox.photoservice.PhotoServiceApplication;
import org.woox.photoservice.service.PhotoServiceImpl;
import org.woox.photoservice.webservice.PhotoServiceWS;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Configuration
public class WebApplicationConfig {
	@Bean
	public PhotoServiceApplication photoServiceApplication() {
		return new PhotoServiceApplication();
	}
	
	@Bean(destroyMethod = "shutdown")
	public SpringBus cxf() {
		return new SpringBus();
	}
	
	@Bean
	@DependsOn("cxf")
	public Server jaxRsServer() {
		JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(photoServiceApplication(),JAXRSServerFactoryBean.class);
		factory.setServiceBeans(Arrays.<Object> asList(photoServiceWS()));
		factory.setAddress(factory.getAddress());
		factory.setProviders(Arrays.<Object> asList(jsonProvider()));
//		 Map<Object, Object> extensionsMap   = new HashMap<Object, Object>();
//	      extensionsMap.put("json", MediaType.APPLICATION_JSON);
//	       extensionsMap.put("xml",MediaType.TEXT_XML);
//		factory.setExtensionMappings(extensionsMap		);
		return factory.create();
	}
	
	@Bean
	public JacksonJsonProvider jsonProvider() {
		return new JacksonJsonProvider();
	}
	

	@Bean
	public PhotoServiceWS photoServiceWS() {
		return new PhotoServiceWS();
	}

	@Bean
	public PhotoServiceImpl photoService() {
		return new PhotoServiceImpl();
	}


}