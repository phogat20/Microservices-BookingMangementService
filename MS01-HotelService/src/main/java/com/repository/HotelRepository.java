package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
