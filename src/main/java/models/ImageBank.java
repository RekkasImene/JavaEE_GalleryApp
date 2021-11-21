package models;

import java.util.List;

public class ImageBank {
	
private final List<ImageCategory> imageCategory;
	
	ImageBank(List<ImageCategory> imageCategory){
		this.imageCategory= imageCategory;
	}
	
	public List<ImageCategory> getTotalImageCategoryInBank(){
		return imageCategory;
	}

}
