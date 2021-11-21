package models;

public class UserService extends User{

	private static final long serialVersionUID = 1L;

	public UserService (String login, String email, String password, String favor) {
		 super(login,email,password,favor);
		 register(login,email,password,favor);
	 }
	
	protected void register(String login, String email, String password, String favor) {
		super.setLogin(login);
		super.setEmail(email);
		super.setPassword(password);
		super.setFavoriteCategory(favor);
	}

}
