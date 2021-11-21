package controllers;

import models.UserService;

public class RequestProcessor {
	
	private String login;
	private String email;
	private String password;
	private String confPass;
	private String favoriteCategory;
	
	
	public RequestProcessor() {
        super();
    }
	
	public RequestProcessor(String login, String email, String password,String confPass, String cat)
			throws DonneesInvalidesException {
		   
		//verifier que tous les champs du formulaire sans remplis
		if (isBlank(login) || isBlank(email) || isBlank(password) || isBlank(confPass) || isBlank(cat)) {
		      throw new DonneesInvalidesException("Certaines donnees ne sont pas renseignees !");
		    }
		   //verifier que le mot de pass contient au moins 5 caractères
		   if (!isValidPassword(password)) {
		    	throw new DonneesInvalidesException("Le mot de pass doit au moins avoir 5 caractères !");
		    	}
		   //verifier que le mot de pass et sa confirmation sont les même
		   if (!isSame(password ,confPass)) {
		    	throw new DonneesInvalidesException("Le mot de pass n'est pas bien confirmé !");
		    	}
		   
		   this.login=login;
		   this.email=email;
		   this.password=password;
		   this.setConfPass(confPass);
		   this.favoriteCategory=cat;
		   process();
		    
	}
		  
	
	protected void process() {
		new UserService(this.login, this.email, this.password, this.favoriteCategory);
		
	}
	
	private static boolean isBlank(String valeur) {
		   return valeur == null || "".equals(valeur);
		  }
	
	private boolean isValidPassword(String password) {
	    return password != null && password.length()>= 5;
	}
	
	private boolean isSame(String password, String confPass) {
	    return password.equals(confPass);
	}

	public String getConfPass() {
		return confPass;
	}

	public void setConfPass(String confPass) {
		this.confPass = confPass;
	}

	
}