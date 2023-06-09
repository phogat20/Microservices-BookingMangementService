package com.feignclientproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.model.Rating;

@FeignClient(name = "RATING-SERIVCE")
public interface RatingServiceProxy {

	@GetMapping("/users/{userId}")
	public Rating getRatingsByUserId(@PathVariable String userId);

	
	
}
