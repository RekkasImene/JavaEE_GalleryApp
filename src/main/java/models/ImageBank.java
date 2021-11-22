package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ImageBank implements Serializable{

	private static final long serialVersionUID = 1L;
private final List<ImageCategory> imageCategoryList= new ArrayList<>();

	public void addImageCategory(ImageCategory imageCategory){
	    imageCategoryList.add(imageCategory);
	}
	
	public List<ImageCategory> getImageCategoryList(){
		return imageCategoryList;
	}
	

    public List<Image> getRandomImages(int number){
        List<Image> imagesList = new ArrayList<>();

        ImageCategory randomCat;
        for (int i=0; i<number; ++i){
            randomCat=imageCategoryList.get((int) (Math.random()*imageCategoryList.size()));
            imagesList.add(randomCat.getRandomImages());
        }

        return imagesList;
    }
    
    public List<Image> getCategoryImages(String category) {
    	 List<Image> imagesList = new ArrayList<>();
    	 	int i=0;
    	 	while (i< imageCategoryList.size() && !imageCategoryList.get(i).getNom().equals(category) ) {
    	 		i++;
    	}
	 		imagesList=imageCategoryList.get(i).getImagesList();
    	 	return imagesList;
    	
    }

}
