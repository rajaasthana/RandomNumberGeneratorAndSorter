package com.randomnumbersorter.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.randomnumbersorter.dto.RandomNumberSortDto;

/**
 * Repository layer for the application. Spring framework will autowire
 * SimpleJpaRepository as the default implementation
 * 
 * @author Raja Asthana
 * @since Dec-2017
 */
public interface RandomNumberSortRepository extends JpaRepository<RandomNumberSortDto, Serializable> {

	/**
	 * Query method to retrieve all data from database sorted by ID descending
	 * 
	 * @return All data from DB
	 */
	public List<RandomNumberSortDto> findAllByOrderByIdDesc();
}
