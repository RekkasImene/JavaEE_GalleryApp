package models;

public class Image {
	
	private String path;
	private String nomI;
	
	Image(String nomI, String path){
		this.path=path;
		this.nomI=nomI;
		}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getNomI() {
		return nomI;
	}
	public void setNomI(String nomI) {
		this.nomI = nomI;
	}

}
