package models;

import java.util.List;

public class ImageCategory {
	private final List<Image> images;
	private String nomC;
	
	ImageCategory(String nomC,List<Image> images){
		this.images=images;
		this.nomC=nomC;
	}
	
	public List<Image> getTotalImagesInCategory(){
		return images;
	}

	public String getNomC() {
		return nomC;
	}

	public void setNomC(String nomC) {
		this.nomC = nomC;
	}
	

}
