package com.microservice.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/review/{name}")
	public Review retrieveReviews(@PathVariable String name) {
		Review review = new Review(100L,name,5.2F,"Was really surprised");
		review.setEnvironment(environment.getProperty("local.server.port"));
		return review;
	}
	

}
