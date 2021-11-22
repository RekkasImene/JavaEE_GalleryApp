package models;

import java.io.Serializable;

public class Image implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String path;
	private String nom;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
