package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feignclientproxy.RatingServiceProxy;
import com.model.User;
import com.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RatingServiceProxy proxy;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User userSaved = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
	}

	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		
		
		User user = userService.getUser(userId);
//		ResponseEntity<List<User>> user = proxy.getRatingsByUserId(userId);		
		return ResponseEntity.ok(user);
	}
	
//	Fall Back Method
	public ResponseEntity<User> ratingHotelFallback(String userId,Exception  ex){
		System.out.println("FallBack is called" + ex.getMessage());
		User user = new User();
		user.setEmail("dummy@gmail.com");
		user.setName("dummy");
		user.setAbout("this is userid");
		user.setUserId("1465");
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}

}
