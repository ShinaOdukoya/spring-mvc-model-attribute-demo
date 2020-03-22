package com.shina.springdemo.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	private Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	@RequestMapping("/home")
	public String home() {
		return "requestMappingAndParamDemo";
	}

	// test 1. Testing @RequestParam without explicit attributes
	@RequestMapping(value = "/test1")
	public String requestMappingAndParamTest1(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test1");

		return "requestMappingAndParamResults";
	}

	// test 2. Testing @RequestMapping method attribute
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String requestMappingAndParamTest2(@RequestParam("orgname") String orgName, Model model) {
		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test2");

		return "requestMappingAndParamResults";
	}

	// test 3. Testing @RequestMapping fallback feature
	@RequestMapping(value = "*", method = RequestMethod.GET)
//	@RequestMapping(value="*", method= {RequestMethod.GET, RequestMethod.POST})
	public String requestMappingAndparamTest3() {

		return "fallback";
	}

	// test 4. Testing @RequestParam 'defaultValue' attribute
	@RequestMapping(value = "/test4")
	public String requestMappingAndParamTest4(
			@RequestParam(value = "orgname", defaultValue = "Anonymous Organization") String orgName, Model model) {

		model.addAttribute("orgname", orgName);
		model.addAttribute("testserial", "test4");
		return "requestMappingAndParamResults";
	}

	// test 5. Testing @RequestParam without the 'name' or 'value' attributes
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingAndParamTest5(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test5");

		return "requestMappingAndParamResults";
	}

//	// test 6. subtest1: Testing @RequestMapping
//	@RequestMapping(value = "/test6")
//	public String requestMappingAndParamTest6Subtest1(@RequestParam String orgname, Model model) {
//		model.addAttribute("orgname", orgname);
//		model.addAttribute("testserial", "test6-subtest1");
//
//		return "requestMappingAndParamResults2";
//	}

	// test 6. subtest1: Testing Removal of @RequestMapping ambiguity with the same
	// base URI but
	// with a different parameter
	@RequestMapping(value = "/test6", params = "orgname")
	public String requestMappingAndParamTest6Subtest1(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest1");

		return "requestMappingAndParamResults2";
	}

//	// test 6. subtest2: Testing @RequestMapping
//	@RequestMapping(value = "/test6")
//	public String requestMappingAndParamTest6Subtest2(@RequestParam String empcount, Model model) {
//		model.addAttribute("orgname", empcount);
//		model.addAttribute("testserial", "test6-subtest-2");
//
//		return "requestMappingAndParamResults2";
//	}

	// test 6. subtest2: Testing Removal of @RequestMapping ambiguity with the same
	// base URI but
	// with a different parameter
	@RequestMapping(value = "/test6", params = "empcount")
	public String requestMappingAndParamTest6Subtest2(@RequestParam String empcount, Model model) {
		model.addAttribute("orgname", empcount);
		model.addAttribute("testserial", "test6-subtest-2");

		return "requestMappingAndParamResults2";
	}

	// test 6. subtest3: Testing Removal of @RequestMapping with multiple request
	// params
	@RequestMapping(value = "/test6/subtest3", method = RequestMethod.GET, params = { "orgname", "empcount" })
	public String requestMappingAndParamTest6Subtest3(@RequestParam String orgname, @RequestParam String empcount,
			Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("empcount", empcount);
		model.addAttribute("testserial", "test6-subtest3");

		return "requestMappingAndParamResults2";
	}

	// test 6. subtest4: Testing multiple request params @RequestParam with single param
	@RequestMapping(value = "/test6/subtest4", method = RequestMethod.GET, params = { "orgname", "empcount" })
	public String requestMappingAndParamTest6Subtest4(@RequestParam String orgname, Model model) {
		model.addAttribute("orgname", orgname);
		model.addAttribute("testserial", "test6-subtest4");

		return "requestMappingAndParamResults2";
	}

	// test 7 & 8: Testing @RequestParam with multiple request URI's
	@RequestMapping(value = { "/test7", "/test8"}, method = RequestMethod.GET)
	public String requestMappingAndParamTestAnd8(@RequestParam String orgname, Model model, HttpServletRequest request) {
		model.addAttribute("orgname", orgname);
		LOGGER.info(request.getRequestURL().toString());
		
		if(request.getRequestURI().toString().contains("test7")) {
			model.addAttribute("testserial", "test7");
		}else {
			model.addAttribute("testserial", "test8");
		}

		return "requestMappingAndParamResults2";
	}
	

}













