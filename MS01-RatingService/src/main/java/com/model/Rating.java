package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_rating")
public class Rating {
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private Integer rating;
	private String feedback;

}
