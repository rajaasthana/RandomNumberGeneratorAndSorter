package com.randomnumbersorter.service.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomnumbersorter.dto.RandomNumberSortDto;
import com.randomnumbersorter.model.RandomNumberSortModel;
import com.randomnumbersorter.repository.RandomNumberSortRepository;
import com.randomnumbersorter.service.RandomNumberSortService;
import com.randomnumbersorter.util.RandomNumberSortUtil;

/**
 * Implementation for Service layer
 * 
 * @author Raja Asthana
 * @since Dec-2017
 */
@Service
public class RandomNumberSortServiceImpl implements RandomNumberSortService {

	@Autowired
	private RandomNumberSortRepository randomNumberSortRepository;

	@Autowired
	private RandomNumberSortUtil randomNumberSortUtil;
	
	@Override
	public String generateRandomNumbers(int limit) {
		return randomNumberSortUtil.toString(randomNumberSortUtil.generateRandomNumber(limit));
	}

	@Override
	public String sortAndPersistRandomNumbers(String numbers) {
		int[] randomNumbers = randomNumberSortUtil.toIntArray(numbers);
		RandomNumberSortDto dto = new RandomNumberSortDto();

		Instant start = Instant.now();
		int[] sortedNumbers = randomNumberSortUtil.sort(randomNumbers, dto);
		Instant end = Instant.now();

		String sortedRandomNumbers = randomNumberSortUtil.toString(sortedNumbers);
		long timeTaken = Duration.between(start, end).toMillis();
		dto.setUnsortedNumber(numbers);
		dto.setSortedNumber(sortedRandomNumbers);
		dto.setSortTime(timeTaken);

		randomNumberSortRepository.save(dto);
		return sortedRandomNumbers;
	}

	@Override
	public List<RandomNumberSortModel> findAllOrderByDesc() {
		List<RandomNumberSortDto> randomNumberSortDtos = randomNumberSortRepository.findAllByOrderByIdDesc();
		return randomNumberSortDtos.stream().map(randomNumberSortUtil::mapToModel).collect(Collectors.toList());
	}
}
