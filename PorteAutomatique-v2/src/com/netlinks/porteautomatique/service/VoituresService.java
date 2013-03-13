package com.netlinks.porteautomatique.service;

import java.util.List;

import com.netlinks.porteautomatique.model.Voiture;


public interface VoituresService {
	
	public List<Voiture> getAll();
	public void add(Voiture v);

}