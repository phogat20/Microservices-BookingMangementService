package com.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

		private String ratingId;
		private String userId;
		private String hotelID;
		private List<Rating> rating;
		private String feedback;
		
		private Hotel hotel;
}
