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
	public void displayHomePage(){
		when(service.findAllOrderByDesc()).thenReturn(new ArrayList<>());
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
	public void generateRandomNumbers(){
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
	public void sortRandomNumbers(){
		String randomNumber = "5,3,99,22,4";
		String sortedNumbersString = "3,4,5,22,99";

		when(service.findAllOrderByDesc()).thenReturn(new ArrayList<>());
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
