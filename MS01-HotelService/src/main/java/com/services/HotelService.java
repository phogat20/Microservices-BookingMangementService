package com.services;

import java.util.List;

import com.model.Hotel;

public interface HotelService {

	Hotel create(Hotel hotel);

	List<Hotel> getAll();

	Hotel get(String id);
}
