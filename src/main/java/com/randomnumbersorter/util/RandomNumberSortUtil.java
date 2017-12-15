package com.randomnumbersorter.util;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.randomnumbersorter.dto.RandomNumberSortDto;
import com.randomnumbersorter.model.RandomNumberSortModel;

@Component
public class RandomNumberSortUtil {

	private static int minIndex, minValue, counter;

	/**
	 * Utility method to generate random numbers using streams api
	 * 
	 * @param limit
	 * @return generated random numbers
	 */
	public int[] generateRandomNumber(int limit) {
		return new Random()
				.ints(limit, 0, 100)
				.toArray();
	}

	/**
	 * Utility method to convert primitive int array to comma separated String
	 * 
	 * @param numbers
	 * @return Comma separated string
	 */
	public String toString(int[] numbers) {
		return Arrays.stream(numbers)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(","));
	}

	/**
	 * Utility method to convert comma separated String to primitive int array
	 * 
	 * @param numbers
	 * @return int array
	 */
	public int[] toIntArray(String numbers) {
		return Arrays.stream(numbers.split(","))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	/**
	 * Utility method to sort random numbers
	 * 
	 * @param randomNumbers
	 * @param dto
	 * @return sorted numbers
	 */
	public int[] sort(int[] randomNumbers, RandomNumberSortDto dto) {
		counter = 0;
		IntStream.range(0, randomNumbers.length).forEach(index -> {
			minIndex = index;
			minValue = randomNumbers[index];

			IntStream.range(minIndex + 1, randomNumbers.length).forEach(unsortedIndex -> {
				if (randomNumbers[unsortedIndex] <= minValue) {
					minValue = randomNumbers[unsortedIndex];
					minIndex = unsortedIndex;
				}
			});

			if (minIndex != index) {
				swap(randomNumbers, minIndex, index);
				counter++;
			}
		});
		dto.setNoOfPositionsChanged(counter);
		return randomNumbers;
	}

	/**
	 * Helper method to populate model from dto object
	 * 
	 * @param dto
	 * @return randomNumberSortModel
	 */
	public RandomNumberSortModel mapToModel(RandomNumberSortDto dto) {
		RandomNumberSortModel randomNumberSortModel = new RandomNumberSortModel();
		randomNumberSortModel.setNoOfPositionsChanged(dto.getNoOfPositionsChanged());
		randomNumberSortModel.setSortedNumbers(dto.getSortedNumbers());
		randomNumberSortModel.setUnsortedNumbers(dto.getUnsortedNumbers());
		randomNumberSortModel.setSortTime(dto.getSortTime());
		
		return randomNumberSortModel;
	}

	/**
	 * Helper method to swap elements within an array
	 * 
	 * @param unsortedNumbers
	 * @param minIdx
	 * @param index
	 */
	private void swap(int[] unsortedNumbers, int minIdx, int index) {
		int temp = unsortedNumbers[minIdx];
		unsortedNumbers[minIdx] = unsortedNumbers[index];
		unsortedNumbers[index] = temp;
	}

}
