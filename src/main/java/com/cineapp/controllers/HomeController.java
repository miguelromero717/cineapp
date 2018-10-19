package com.cineapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cineapp.domain.Pelicula;

@Controller
public class HomeController {

	@GetMapping(value = "/detail")
	public String mostrarDetalle(Model model) {
		String tituloPelicula = "Rapido y Fusioso 8";
		int duracion = 136;
		double precioEntrada = 50;
		
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		
		return "detalle";
	}
	
	@GetMapping(value = "/home")
	public String mostrarPrincipal(Model model) {
		List<Pelicula> peliculas = new ArrayList<>();
//		peliculas.add("Rapido y furioso");
//		peliculas.add("Aliens");
//		peliculas.add("Rambo");
		model.addAttribute("peliculas", peliculas);
		
		return "home";
	}
	
}
