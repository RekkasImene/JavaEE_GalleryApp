package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ImageCategory implements Serializable{

	private static final long serialVersionUID = 1L;
	private final List<Image> imagesList;
	private String nom;
	
	public ImageCategory() {
        imagesList = new ArrayList<>();
    }

    public void addImage(Image image){
        imagesList.add(image);
    }
	
	
	public List<Image> getImagesList(){
		return imagesList;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom= nom;
	}

    public Image getRandomImages() {
        return imagesList.get((int) (Math.random()*imagesList.size()));
    }
	

}
