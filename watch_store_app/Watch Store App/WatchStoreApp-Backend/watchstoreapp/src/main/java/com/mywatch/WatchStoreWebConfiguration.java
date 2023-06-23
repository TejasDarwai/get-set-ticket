package com.mywatch;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WatchStoreWebConfiguration implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") 					// Here we are specifying urls on server which we want to make accessable
		.allowedOrigins("http://localhost:4200") 	// Here we are specifying ip and port of client from where request is made.
		.allowedMethods("*"); 						// Here we are specifying httpmethod we are giving access to client
	}
}
