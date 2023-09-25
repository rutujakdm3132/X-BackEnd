package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Basket;


public interface BasketRepository extends JpaRepository<Basket, Integer> {

	@Query("Select b from Basket b where b.user.id=:id")
	List<Basket> findBasketByUserId(@Param("id") int id);

}
