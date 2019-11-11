package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

	@GetMapping("/{variable1}/{variable2}")
	public String home(@PathVariable(name="variable1") String var1, @PathVariable(name="variable2") String var2) {
		System.out.println("Se redirige usando IndexController, los valores pasados son:  " + var1 + ", y " + var2);
		return "redirect:/app/index";
		//return "redirect:http://www.google.es";
	}
	@GetMapping("/forward")
	public String homeForward() {
		return "forward:/app/index";
	}
	
}
