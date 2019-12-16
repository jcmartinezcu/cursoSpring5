package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({"/index", "/", "","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring frameWork con Model!!");
		return "index";
		
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("Guzman");	
		usuario.setEmail("andres@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		
		return "perfil";		
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "Guzman", "andres@correo.es"),
				new Usuario("Juan","Martinez", "juan@correo.com"),
				new Usuario("Carlos", "Cutillas", "carlos@hotmail.com"),
				new Usuario("Tornado", "Roe", "roe@hotmail.com"));
		

		
		model.addAttribute("titulo", "listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
}
