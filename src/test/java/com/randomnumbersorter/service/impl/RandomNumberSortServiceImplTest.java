package com.randomnumbersorter.service.impl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.randomnumbersorter.dto.RandomNumberSortDto;
import com.randomnumbersorter.model.RandomNumberSortModel;
import com.randomnumbersorter.repository.RandomNumberSortRepository;
import com.randomnumbersorter.service.RandomNumberSortService;
import com.randomnumbersorter.util.RandomNumberSortUtil;

@RunWith(SpringRunner.class)
public class RandomNumberSortServiceImplTest {
	
	@TestConfiguration
    static class RandomNumberSortServiceImplTestConfiguration {
  
        @Bean
        public RandomNumberSortService randomNumberSortService() {
            return new RandomNumberSortServiceImpl();
        }
    }

	@Autowired
	private RandomNumberSortService service;

	@MockBean
	private RandomNumberSortRepository repository;

	@MockBean
	private RandomNumberSortUtil util;

	@Test
	public void testGenerateRandomNumbers(){
		String randomNumbers = "5,3,99,22,4";
		int[] randomNumberArray = {5,3,99,22,4};
		
		when(util.generateRandomNumber(5)).thenReturn(randomNumberArray);
		when(util.toString(randomNumberArray)).thenReturn(randomNumbers);
		
		String generatedRandomNumbers = service.generateRandomNumbers(5);
		Assert.assertEquals(randomNumbers, generatedRandomNumbers);
	}
	
	@Test
	public void testSortAndPersistRandomNumbers(){
		String randomNumbersString = "5,3,99,22,4";
		int[] randomNumberArray = {5,3,99,22,4};
		int[] sortedArray = {3,4,5,22,99};
		String sortedNumbersString = "3,4,5,22,99";
		
		RandomNumberSortDto dto = new RandomNumberSortDto();
		
		when(util.toIntArray(randomNumbersString)).thenReturn(randomNumberArray);
		when(util.sort(Matchers.anyObject(), Matchers.any(RandomNumberSortDto.class))).thenReturn(sortedArray);
		when(util.toString(sortedArray)).thenReturn(sortedNumbersString);
		when(repository.save(dto)).thenReturn(dto);
		
		String sortedRandomNumbers = service.sortAndPersistRandomNumbers(randomNumbersString);

		Assert.assertEquals(sortedNumbersString, sortedRandomNumbers);
	}
	
	@Test
	public void testFindAllOrderByDesc(){
		String randomNumbersString = "5,3,99,22,4";
		String sortedNumbersString = "3,4,5,22,99";
		
		List<RandomNumberSortDto> dtos = new ArrayList<>();
		
		RandomNumberSortDto dto1 = populateDto(1, randomNumbersString, sortedNumbersString, 5, 25);
		RandomNumberSortDto dto2 = populateDto(2, randomNumbersString, sortedNumbersString, 4, 18);
		dtos.add(dto1);
		dtos.add(dto2);

		RandomNumberSortModel modelForDTO1 = populateModel(1, randomNumbersString, sortedNumbersString, 5, 25);
		RandomNumberSortModel modelForDTO2 = populateModel(2, randomNumbersString, sortedNumbersString, 4, 18);
		
		when(repository.findAllByOrderByIdDesc()).thenReturn(dtos);
		
		when(util.mapToModel(dto1)).thenReturn(modelForDTO1);
		when(util.mapToModel(dto2)).thenReturn(modelForDTO2);
		
		List<RandomNumberSortModel> dataModels = service.findAllOrderByDesc();

		Assert.assertNotNull(dataModels);
		Assert.assertTrue(2 == dataModels.size());
		Assert.assertTrue(dataModels.get(0).getNoOfPositionChanged() == 5);
	}
	
	private RandomNumberSortDto populateDto(int id, String unsortedNumber, String sortedNumber, int positionChanged, long timeTaken){
		RandomNumberSortDto dto = new RandomNumberSortDto();
		dto.setId(id);
		dto.setNoOfPositionChanged(positionChanged);
		dto.setSortedNumber(sortedNumber);
		dto.setUnsortedNumber(unsortedNumber);
		dto.setSortTime(timeTaken);
		return dto;
	}
	
	private RandomNumberSortModel populateModel(int id, String unsortedNumber, String sortedNumber, int positionChanged, long timeTaken){
		RandomNumberSortModel model = new RandomNumberSortModel();
		model.setNoOfPositionChanged(positionChanged);
		model.setSortedNumber(sortedNumber);
		model.setUnsortedNumber(unsortedNumber);
		model.setSortTime(timeTaken);
		return model;
	}
}
