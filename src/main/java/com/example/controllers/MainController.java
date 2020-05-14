package com.example.controllers;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.models.dao.ColorDaoImpl;

@Controller
public class MainController {
	@Autowired
	private ColorDaoImpl colorDaoImpl;

	@RequestMapping(value = "/colors", produces="application/json")
	@ModelAttribute("colors")
	public JSONArray test() {
		JSONArray array = new JSONArray();
		array.put(colorDaoImpl.getColors());
		return array.getJSONArray(0);
	}
	
	@RequestMapping("/getInfo")
	@ModelAttribute("info")
	public String getInfo(@RequestParam String input) {
		return colorDaoImpl.getInfo(input);
	}
}
