package com.javaport.client.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetingResource {
// invoked through zuul reverse proxying mecahnism
	@GetMapping("/greetings")
	public String greet(){
		
		return "OLA from Hello-client service";
	}
	
}
