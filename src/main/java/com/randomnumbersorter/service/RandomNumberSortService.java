package com.randomnumbersorter.service;

import java.util.List;

import com.randomnumbersorter.model.RandomNumberSortModel;

/**
 * Contract for Service layer
 * 
 * @author Raja Asthana
 * @since Dec-2017
 */
public interface RandomNumberSortService {

	/**
	 * Method to generate random numbers
	 * 
	 * @param limit
	 * @return generated random numbers
	 */
	public String generateRandomNumbers(int limit);

	/**
	 * Method to sort and save random numbers to H2 Database
	 * 
	 * @param numbers
	 * @return sorted random numbers
	 */
	public String sortAndPersistRandomNumbers(String numbers);

	/**
	 * Method to retrieve all data from DB
	 * 
	 * @return all data (sorted/unsorted) from DB
	 */
	public List<RandomNumberSortModel> findAllOrderByDesc();

}
