package com.randomnumbersorter.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.randomnumbersorter.dto.RandomNumberSortDto;
import com.randomnumbersorter.model.RandomNumberSortModel;

@RunWith(SpringRunner.class)
public class RandomNumberSortUtilTest {

	@Autowired
	private RandomNumberSortUtil randomNumberSortUtil;

	
	@TestConfiguration
    static class RandomNumberSortUtilTestConfiguration {
  
        @Bean
        public RandomNumberSortUtil randomNumberSortUtil() {
            return new RandomNumberSortUtil();
        }
    }
	@Test
	public void generateRandomNumbers(){
		int[] generatedRandomNumbers = randomNumberSortUtil.generateRandomNumber(5);
		Assert.assertTrue(generatedRandomNumbers.length == 5);
	}

	@Test
	public void convertPrimitiveArrayToString(){
		int[] randomNumberArray = {5,3,99,22,4};
		String expectedValue = "5,3,99,22,4";
		String generatedRandomNumbers = randomNumberSortUtil.toString(randomNumberArray);
		Assert.assertEquals(expectedValue, generatedRandomNumbers);
	}

	@Test
	public void toIntArray(){
		String randomNumber = "5,3,99,22,4";
		int[] expectedValue = {5,3,99,22,4};
		int[] generatedRandomNumbers = randomNumberSortUtil.toIntArray(randomNumber);
		Assert.assertEquals(expectedValue[0], generatedRandomNumbers[0]);
		Assert.assertEquals(expectedValue[2], generatedRandomNumbers[2]);
	}
	
	@Test
	public void sort(){
		int[] randomArray = {5,3,99,22,4};
		int[] expectedArray = {3,4,5,22,99};
		
		int[] sortedNumber = randomNumberSortUtil.sort(randomArray, new RandomNumberSortDto());
		Assert.assertEquals(expectedArray[0], sortedNumber[0]);
		Assert.assertEquals(expectedArray[2], sortedNumber[2]);
	}
	
	@Test
	public void mapToModel(){
		String randomNumbersString = "5,3,99,22,4";
		String sortedNumbersString = "3,4,5,22,99";

		RandomNumberSortDto dto = populateDto(1, randomNumbersString, sortedNumbersString, 5, 25);
		
		RandomNumberSortModel model = randomNumberSortUtil.mapToModel(dto);
		Assert.assertEquals(sortedNumbersString, model.getSortedNumber());
		Assert.assertEquals(randomNumbersString, model.getUnsortedNumber());
		Assert.assertTrue(5 == model.getNoOfPositionChanged());
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
}
