package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required=false, defaultValue="Andrés Guzmán") String texto,  Model model){
		
		model.addAttribute("titulo", "Pantalla de parámetros");
		model.addAttribute("texto","El texto es de esta forma:  " + texto);
		return "params/ver";
		
	}
	
	@GetMapping("/mix-params")
	public String mixParams(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		
		model.addAttribute("saludo", "El saludo enviado es " + saludo);
		model.addAttribute("numero", "El número enviado es " + numero);
		
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String mixParamsRequest(HttpServletRequest httpRequest,  Model model) {
		
		String saludo = httpRequest.getParameter("saludo");
		Integer numero = null;
		
		try {
			numero = Integer.parseInt(httpRequest.getParameter("numero"));
		}catch(NumberFormatException ex) {
			numero = 0;
		}
		
		model.addAttribute("saludo", saludo);
		model.addAttribute("numero",numero);
		
		return "params/ver";
	}
	

}
