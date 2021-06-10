package com.example.potager.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeEcran {

	@GetMapping("/home")
	public String home() {

		return "home/home";
	}
}
