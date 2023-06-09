package com.service;

import java.util.List;

import com.model.Rating;

public interface RatingService {

	Rating createRating(Rating rating);

	List<Rating> getAllRatings();

	List<Rating> getRatingByUserId(String userId);

	List<Rating> getRatingByHotelId(String hotelId);

}
