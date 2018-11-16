package com.cineapp.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cineapp.services.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cineapp.domain.Pelicula;
import com.cineapp.util.UtilCineApp;

@Controller
public class HomeController {

    @Autowired
    PeliculasService peliculasService;

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	
	@GetMapping(value = "/detalle/{id}/{fecha}")
	public String mostrarDetalle(Model model, @PathVariable("id") int id, @PathVariable("fecha") String fecha) {
	    model.addAttribute("pelicula", this.peliculasService.findById(id));
		return "detalle";
	}
	
	@GetMapping(value = "/")
	public String mostrarPrincipal(Model model) {
		List<String> fechas = UtilCineApp.generateFechas(5);
		List<Pelicula> peliculas = this.peliculasService.buscarTodas();
		model.addAttribute("fechas", fechas);
		model.addAttribute("fecha", formatter.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		return "home";
	}
	
	@PostMapping(value="/search")
	public String buscar(Model model, @RequestParam("fecha") String fecha) {
		List<String> fechas = UtilCineApp.generateFechas(5);
		List<Pelicula> peliculas = this.peliculasService.buscarTodas();
		model.addAttribute("fechas", fechas);
		model.addAttribute("fecha", fecha);
		model.addAttribute("peliculas", peliculas);
		return "home";
	}
	
}
