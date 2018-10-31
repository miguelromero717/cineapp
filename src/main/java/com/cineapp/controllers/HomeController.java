package com.cineapp.controllers;

import java.text.SimpleDateFormat;
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
	
	@GetMapping(value = "/")
	public String mostrarPrincipal(Model model) {
		List<Pelicula> peliculas = getLista();
		model.addAttribute("peliculas", peliculas);
		return "home";
	}
	
	private List<Pelicula> getLista() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		List<Pelicula> lista = null;
		try {
			lista = new ArrayList<>();
			
			Pelicula p1 = new Pelicula();
			p1.setId(1);
			p1.setTitulo("Titanic");
			p1.setDuracion(197);
			p1.setClasificacion("B");
			p1.setGenero("Drama");
			p1.setFechaEstreno(formatter.parse("22/10/2018"));
			p1.setImagen("titanic.jpg");
			p1.setStatus("Inactiva");
			
			Pelicula p2 = new Pelicula();
			p2.setId(2);
			p2.setTitulo("Jumanji");
			p2.setDuracion(120);
			p2.setClasificacion("B");
			p2.setGenero("Acción");
			p2.setFechaEstreno(formatter.parse("23/10/2018"));
			p2.setImagen("jumanji.jpg");
			
			Pelicula p3 = new Pelicula();
			p3.setId(3);
			p3.setTitulo("Ace Ventura");
			p3.setDuracion(118);
			p3.setClasificacion("B");
			p3.setGenero("Comedia");
			p3.setFechaEstreno(formatter.parse("24/10/2018"));
			p3.setImagen("ace_ventura.jpg");
			
			Pelicula p4 = new Pelicula();
			p4.setId(4);
			p4.setTitulo("Monsters Inc");
			p4.setDuracion(95);
			p4.setClasificacion("B");
			p4.setGenero("Infantil");
			p4.setFechaEstreno(formatter.parse("25/10/2018"));
			p4.setImagen("monsters.jpg");
			
			lista.add(p1);
			lista.add(p2);
			lista.add(p3);
			lista.add(p4);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
