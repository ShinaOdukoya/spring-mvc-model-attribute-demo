package com.shina.springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shina.springdemo.domain.Address;

@Controller
public class ModelAttributeDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(ModelAttributeDemoController.class);

	@RequestMapping(value = "/home")
	public String home() {
		LOGGER.info("INSIDE home: " + System.currentTimeMillis());
		return "modelAttributeHome";
	}
	
	//version 2 of our home() method
	@RequestMapping(value= "/home2")
	public ModelAndView home2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modelAttributeHome");
		mav.addObject("command", new Address());
		return mav;
	}
	
	//version 3 of our home() method
	@RequestMapping(value= "/home3")
	public ModelAndView home3() {
		ModelAndView mav = new ModelAndView("modelAttributeHome");
		mav.addObject("anAddress", new Address());
		return mav;
	}
	
	//version 4 of our home() method
	@RequestMapping(value= "/home4")
	public ModelAndView home4() {
		return new ModelAndView("modelAttributeHome", "anAddress", new Address("Ibadan","3000"));
	}
	
	//version 5 of our home() method
	@RequestMapping(value= "/home5")
	public String home5(Model model) {
		model.addAttribute("anAddress", new Address("Ontario","3000"));
		return "modelAttributeHome";
	}

	/*
	 * Test series to demonstrate the usage of @ModelAttribute annotation (on a
	 * method)
	 */

	// Demonstrating the usage of @ModelAttribute annotation (on a method)
	// to add multiple attributes
	@ModelAttribute
	public void modelAttributeTest1(Model model) {
		LOGGER.info("INSIDE modelAttributeTest1: " + System.currentTimeMillis());
		model.addAttribute("testData1A", "Welcome to the @ModelAttribute Test Bed!");
		model.addAttribute("tesData1B", "We will test the usage of @ModelAttribute both on methods and arguments");
	}

	// Demonstrating the usage of the name attribute' attribute of @ModelAttribute
	// annotation on (method)
	@ModelAttribute(name = "testdata2")
	public String modelAttributeTest2() {
		LOGGER.info("INSIDE modelAttributeTest2");
		return "We will conduct a series of test";
	}
	
	//Test 3. Demonstrating the usage of the @ModelAttribute annotation (on method) to implicitly add an attribute
	//by returning it and also demonstrating the usage of the value' attribute of @ModelAttribute annotation (on a method)
	@ModelAttribute(value="testdata3")
	public Address modelAttributeTest3() {
		LOGGER.info("INSIDE modelAttributeTest3");
		return new Address("Lagos", "5000");
	}
	
	//Test 4. To demonstrate the default naming strategy of @ModelAttribute annotation (on a method)
	@ModelAttribute
	public Address modelAttributeTest4() {
		LOGGER.info("INSIDE modelAttributeTest4");
		return new Address("PH", "2000");
	}
	
	//Test 5. Testing the @ModelAttribute with 'value' attribute and default binding
	@RequestMapping(value="/test5", method=RequestMethod.POST)
	public String modelAttributeTest5(@ModelAttribute(value="anAddress") Address anAddress, Model model) {
		model.addAttribute("testdata5A", anAddress.getCity());
		model.addAttribute("testdata5B", anAddress.getZipCode());
		return "modelAttributeTest";
	}
	
	// Test 6. Test to determine the nature of how @ModelAttribute(on method) and @RequestMapping work 
	//with no explicit logical name
	@RequestMapping(value="/modelAttributeTest")
	@ModelAttribute("testdata6")
	public Address ModelAttributeTest6() {
		return new Address("Jos", "2390");
	}

}











