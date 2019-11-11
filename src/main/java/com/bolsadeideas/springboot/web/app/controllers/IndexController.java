package com.bolsadeideas.springboot.web.app.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.index.controller.titulo}")
	private String tituloIndex;
	@Value("${texto.index.controller.perfil}")
	private String tituloPerfil;
	@Value("${texto.index.controller.listado}")
	private String tituloListar;
	
	
	

	@GetMapping({"/index", "/", "", "/home"})
	public ModelAndView index(ModelAndView  mv) {
		mv.addObject("titulo",tituloIndex);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("Guzmán");
		usuario.setEmail("andres@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", tituloPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping(value="/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", tituloListar);
		
		return "lista";
	}
	
	@ModelAttribute("usuarios")
	List<Usuario> poblarUsuarios(){
		List<Usuario>  usuarios = Arrays.asList(
				new Usuario("Andrés", "Guzmán", "andres@correo.com"),
				new Usuario("John", "Doe", "john@correo.com"),
				new Usuario("Jane", "Doe", "jane@correo.com"));
		
		return usuarios;
	}
}
