package com.cineapp.services;

import com.cineapp.domain.Pelicula;

import java.util.List;

public interface PeliculasService {

    List<Pelicula> buscarTodas();

    Pelicula findById(int id);

}
