package models;

import java.io.Serializable;

public class User implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private String login;
	private String email;
	private String password;
	private String favoriteCategory;
	
	public User() {
		super();
	}
	
	public User(String login,String email, String password, String favor ) {
		super();
		this.login=login;
		this.email=email;
		this.password=password;
		this.favoriteCategory=favor;
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getemail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFavoriteCategory() {
		return favoriteCategory;
	}

	public void setFavoriteCategory(String favoriteCategory) {
		this.favoriteCategory = favoriteCategory;
	}

}
