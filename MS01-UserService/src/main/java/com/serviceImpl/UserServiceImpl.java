package com.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exception.ResourceNotFoundException;
import com.feignclientproxy.HotelServiceProxy;
import com.feignclientproxy.RatingServiceProxy;
import com.model.Hotel;
import com.model.Rating;
import com.model.User;
import com.repository.UserRepository;
import com.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private RatingServiceProxy ratingProxy;
//	
//	@Autowired
//	private HotelServiceProxy hotelServiceProxy;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();

	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found" + userId));
		// fetch rating from rating service
//		Rating rating = ratingProxy.getRatingsByUserId(userId);
//		user.setRatings(((List<Rating>) rating));
//		Hotel hotel = hotelServiceProxy.getHotel(userId)
//		http://localhost:8083/ratings/users/29ef8c74-e9ec-484b-807c-dcdef5478d9b
		// USING- REST Template
		Rating[] ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(),
				Rating[].class);

		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

		List<Rating> ratingList = ratings.stream().map(rating -> {
			ResponseEntity<Hotel> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/hotels/" + rating.getHotelID(), Hotel.class);
			Hotel hotel = responseEntity.getBody();

			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);
		return user;
	}

}
