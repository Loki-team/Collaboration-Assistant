package com.netcracker.ca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hr")
public class HRController {

	@RequestMapping("")
	public String projects() {

		// TODO "hrProjects"
		return "home";
	}
}
