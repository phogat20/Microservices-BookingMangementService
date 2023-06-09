package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {

	List<Rating> findByUserId(String userId);
	
	List<Rating> findByhotelId(String hotelId);
	
	
	
}
