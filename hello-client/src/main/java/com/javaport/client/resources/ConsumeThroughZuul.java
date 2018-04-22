package com.javaport.client.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeThroughZuul {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/zuultest")
	public String callTest(){
		
		 String url = "http://zuul-service/reverse";
		 String result = template.getForObject(url, String.class);
		return result;
		
		
	}
	
}
