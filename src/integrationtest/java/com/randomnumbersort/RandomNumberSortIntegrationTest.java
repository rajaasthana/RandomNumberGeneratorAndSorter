package com.randomnumbersort;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.randomnumbersorter.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
@AutoConfigureMockMvc
public class RandomNumberSortIntegrationTest {
	@Autowired
    private MockMvc mockMvc;
 
    @Test
	public void testGenerateRandomNumbers(){
		try {
			mockMvc.perform(post("/generate").param("limit", "5"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("randomNumbers", Matchers.notNullValue()))
				.andExpect(view().name("home"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"));
		} catch (Exception e) {
			Assert.fail();
		}
	}
    
    @Test
	public void testSortRandomNumber(){
		try {
			String randomNumber = "5,3,99,22,4";
			String sortedNumbersString = "3,4,5,22,99";
			mockMvc.perform(post("/sort").param("numbers", randomNumber))
				.andExpect(status().isOk())
				.andExpect(model().attribute("sortedRandomNumbers", Matchers.equalTo(sortedNumbersString)))
				.andExpect(model().attribute("numbers", Matchers.notNullValue()))
				.andExpect(model().attribute("numbers", Matchers.hasSize(Matchers.greaterThan(0))))
				.andExpect(view().name("home"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"));
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
