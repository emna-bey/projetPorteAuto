package com.netlinks.porteautomatique.mock;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.netlinks.porteautomatique.model.Voiture;
import com.netlinks.porteautomatique.service.VoituresService;

public class mockVoituresService implements VoituresService{

	@Override
	public List<Voiture> getAll() {
		
		List<Voiture> voitures = new ArrayList<Voiture>();
		Voiture v1 = new Voiture("1275tn160","rouge","emna bey", new Date(2012,2,23));
		voitures.add(v1);
		Voiture v2 = new Voiture("1508tn123","noir","ghassen hadded", new Date(2012,1,15));
		voitures.add(v2);
		Voiture v3 = new Voiture("325tn145","blanc","sami bey", new Date(2012,2,5));
		voitures.add(v3);
		Voiture v4 = new Voiture("3700tn91","bleu","bechir bey", new Date(2012,2,5));
		voitures.add(v4);
		Voiture v5 = new Voiture("140tn98","blanc","yessn hadded", new Date(2012,7,7));
		voitures.add(v5);
		Voiture v6 = new Voiture("102tn130","bleu","ghazy hadded", new Date(2012,17,10));
		voitures.add(v6);
		
		return voitures;
	}

	@Override
	public void add(Voiture v) {
		// TODO Auto-generated method stub
	}

}
