package com.feignclientproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.model.Hotel;

@FeignClient(name = "HOTEL-SERIVCE")
public interface HotelServiceProxy {

	@GetMapping("/hotels/{hotelId}")
	 Hotel getHotel(@PathVariable String hotelId);
	
}
