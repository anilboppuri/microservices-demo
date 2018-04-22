package com.javaport.client.resources;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RefreshScope
@RestController
@RequestMapping("/rest/hello/client")
public class HitHelloResource {

	@Autowired
	private RestTemplate template;
	
	@Value("${serviceuri}")
	String uriPath;
	
	@GetMapping
	public String hitHello(){
		
	
	// for hitting directly :       String url = "http://localhost:8091/rest/hello/service";
	// for hitting through eureka: 	String url = "http://HELLO-SERVICE/rest/hello/service";
	// for hitting through config + Eureka : 	
		String host="http://HELLO-SERVICE"; 
		String url= host+uriPath;
		return template.getForObject(url, String.class);
		
	}
	
}
