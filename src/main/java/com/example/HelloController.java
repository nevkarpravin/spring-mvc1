package com.example;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;


@RestController
public class HelloController {


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		ModelAndView modelAndview = new ModelAndView("home");
		modelAndview.addObject("serverTime", formattedDate);

		return modelAndview;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Locale locale, Model model) {
		ModelAndView modelAndview = new ModelAndView("login");
		return modelAndview;
	}
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		ModelAndView modelAndview = new ModelAndView("user");
		modelAndview.addObject("userName", user.getUserName());
		if(user.getUserName().equalsIgnoreCase("Admin") && user.getPassword().equalsIgnoreCase("pass")) {
	//	ModelAndView modelAndview = new ModelAndView("user");
		modelAndview.addObject("userName", user.getUserName());
		return modelAndview;
		} else {
			return new ModelAndView("Error");
		}
		//model.addAttribute("userName", user.getUserName());
		//return modelAndview;
	}


}
