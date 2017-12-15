package com.randomnumbersorter.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.randomnumbersorter.service.RandomNumberSortService;

@RunWith(SpringRunner.class)
@WebMvcTest(RandomNumberSortController.class)
public class RandomNumberSortControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RandomNumberSortService service;
	
	@Test
	public void displayHomePageOk(){
		when(service.findAllSortedNumbersOrderByDesc()).thenReturn(new ArrayList<>());
		try {
			mockMvc.perform(get("/home"))
				.andExpect(status().isOk())
				.andExpect(view().name("home"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void displayHomePageNotFound(){
		when(service.findAllSortedNumbersOrderByDesc()).thenReturn(new ArrayList<>());
		try {
			mockMvc.perform(get("/invalidHome"))
				.andExpect(status().is(404));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void generateRandomNumbersOk(){
		String randomNumber = "5,3,99,22,4";
		when(service.generateRandomNumbers(5)).thenReturn(randomNumber);
		try {
			mockMvc.perform(post("/generate").param("limit", "5"))
				.andExpect(status().isOk())
				.andExpect(view().name("home"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void generateRandomNumbersException(){
		String randomNumber = "5,3,99,22,4";
		when(service.generateRandomNumbers(5)).thenReturn(randomNumber);
		try {
			mockMvc.perform(post("/generate").param("limit", "text"))
				.andExpect(status().is(200))
				.andExpect(view().name("error"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/error.jsp"));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void sortRandomNumbersOk(){
		String randomNumber = "5,3,99,22,4";
		String sortedNumbersString = "3,4,5,22,99";

		when(service.findAllSortedNumbersOrderByDesc()).thenReturn(new ArrayList<>());
		when(service.sortAndPersistRandomNumbers(randomNumber)).thenReturn(sortedNumbersString);
		try {
			mockMvc.perform(post("/sort").param("numbers", randomNumber))
				.andExpect(status().isOk())
				.andExpect(view().name("home"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"));
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
