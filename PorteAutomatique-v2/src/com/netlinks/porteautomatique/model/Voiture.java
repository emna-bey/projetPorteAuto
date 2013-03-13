package com.netlinks.porteautomatique.model;

import java.util.Date;

public class Voiture {
	String matricule;
	String couleur;
	String nomProp;
	Date dateAjout;
	
	public Voiture(String matricule, String couleur, String nomProp, Date dateAjout) {
		this.matricule = matricule;
		this.couleur = couleur;
		this.nomProp = nomProp;
		this.dateAjout = dateAjout;
	}
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getNomProp() {
		return nomProp;
	}
	public void setNomProp(String nomProp) {
		this.nomProp = nomProp;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
	

}
