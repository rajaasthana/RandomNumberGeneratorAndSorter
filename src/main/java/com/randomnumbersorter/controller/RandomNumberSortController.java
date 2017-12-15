package com.randomnumbersorter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.randomnumbersorter.service.RandomNumberSortService;

/**
 * Controller class to handle request to generate and sort random numbers
 * 
 * @author Raja Asthana
 * @since Dec-2017
 */
@Controller
@SessionAttributes("numbers")
public class RandomNumberSortController {

	@Autowired
	private RandomNumberSortService randomNumberSortService;

	/**
	 * Controller method to display home page (mapping: "/")
	 * 
	 * @return home page view
	 */
	@RequestMapping("/home")
	public ModelAndView displayHomePage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("numbers", randomNumberSortService.findAllOrderByDesc());
		return modelAndView;
	}

	/**
	 * Controller method to generate random numbers (mapping: "/generate")
	 * 
	 * @return home page view
	 */
	@RequestMapping("/generate")
	public ModelAndView generateRandomNumber(@RequestParam("limit") int limit) {
		ModelAndView modelAndView = new ModelAndView("home");
		String randomNumbers = randomNumberSortService.generateRandomNumbers(limit);
		modelAndView.addObject("randomNumbers", randomNumbers);
		return modelAndView;
	}

	/**
	 * Controller method to sort random numbers (mapping: "/sort")
	 * 
	 * @return home page view
	 */
	@RequestMapping("/sort")
	public ModelAndView sortRandomNumber(@RequestParam("numbers") String numbers) {
		ModelAndView modelAndView = new ModelAndView("home");
		String sortedRandomNumbers = randomNumberSortService.sortAndPersistRandomNumbers(numbers);
		modelAndView.addObject("sortedRandomNumbers", sortedRandomNumbers);
		modelAndView.addObject("numbers", randomNumberSortService.findAllOrderByDesc());
		return modelAndView;
	}

	/**
	 * Controller method to handle any exception
	 * 
	 * @return error page view
	 */
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "error";
	}
}
