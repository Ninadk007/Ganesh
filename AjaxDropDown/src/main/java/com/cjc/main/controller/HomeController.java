package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjc.main.model.City;
import com.cjc.main.model.Country;
import com.cjc.main.model.State;
import com.cjc.main.service.ServiceI;

@Controller
public class HomeController {

	@Autowired
	ServiceI si;
	
	
	@RequestMapping("/")
	public String prelogin()
	{
		return "address";
	}
	
	@ResponseBody
	@RequestMapping(value="/getcountry",method = RequestMethod.GET,produces = "application/json")
	public List<Country> country()
	{
		List<Country> l = si.getcountry();
		return l;
	}
	
	@ResponseBody
	@RequestMapping(value="/getstate",method = RequestMethod.GET,produces = "application/json")
	public List<State> state(@RequestParam int c)
	{
		List<State> l = si.getstate(c);
		System.out.println(l);
		return l;
	}
	
	@ResponseBody
	@RequestMapping(value="/getcity",method = RequestMethod.GET,produces = "application/json")
	public List<City> city(@RequestParam int ct)
	{
		List<City> l = si.getcity(ct);
		System.out.println(l);
		
		return l;
	}
}
