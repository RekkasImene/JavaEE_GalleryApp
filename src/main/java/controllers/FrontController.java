package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Image;
import models.ImageBank;
import models.ImageCategory;


/*@WebServlet( 
urlPatterns = "/gallery",
initParams = {
@WebInitParam(name = "imagesFolder", value = "/WEB-INF/images")
})*/

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private static final String VUE_FORMULAIRE = "/views/registration.jsp";
    private static final String VUE_RESULTAT = "/views/gallery.jsp";
    
    
    static File dir;
    List<String> categoryList= new ArrayList<String>();
    public final ImageBank imageBank = new ImageBank();
    public String categoyU;

    @Override
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	ServletContext context = getServletContext();
    	String imagesPath =context.getRealPath(config.getInitParameter("imagesFolder"));
		
		Path directory = Paths.get(imagesPath);
		

		try {
			Files.walk(directory, 1).filter(entry -> !entry.equals(directory))
		    .filter(Files::isDirectory).forEach(subdirectory ->
		    {
		    String categoryName =subdirectory.getFileName().toString();
		    System.out.println(categoryName);
		    categoryList.add(categoryName);
		    ImageCategory category = new ImageCategory();
            category.setNom(categoryName);
            imageBank.addImageCategory(category);
            
            dir = new File(imagesPath+"/"+categoryName);
            for (String imageName: Objects.requireNonNull(dir.list())) {
            	System.out.println(imageName);
                Image image = new Image();
                image.setNom(imageName);
                image.setPath(categoryName);
                category.addImage(image);
            }
            
		    
		    });
			
		} catch (IOException e) {
			 System.out.println("Fichier vide "+e.getMessage());
		}
		
		context.setAttribute("listCategory", categoryList);
		context.setAttribute("bank", imageBank);
		
		if(context.getAttribute("category")== null) {
			context.removeAttribute("images");
			context.setAttribute("images",((ImageBank) context.getAttribute("bank")).getRandomImages(50));
		}else {
			
			context.removeAttribute("images");
		    context.setAttribute("images",((ImageBank) context.getAttribute("bank")).getCategoryImages(context.getAttribute("category").toString()));
		}
    	
    }
    
    	
    



	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd;
		if(categoyU == null) {
			req.removeAttribute("images");
			req.setAttribute("images",imageBank.getRandomImages(50));
		}else {
			req.removeAttribute("images");
			req.setAttribute("images",imageBank.getCategoryImages(categoyU));
		}
		
		if (RequestProcessor.whichPage(req.getParameter("page")).equals("gallery")) {
			rd = req.getRequestDispatcher(VUE_RESULTAT);
			rd.forward(req, resp);
			
		}else if (RequestProcessor.whichPage(req.getParameter("page")).equals("registration")) {
			rd = req.getRequestDispatcher(VUE_FORMULAIRE);
			rd.forward(req, resp);
		}
	      
		
	}
	
	


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	    try {
	    	String login = req.getParameter("login");
			String email= req.getParameter("email");
			String password = req.getParameter("password");
			String confPass = req.getParameter("confPass");
			String cat= req.getParameter("cat");
	      
	      RequestProcessor reqProc = new RequestProcessor(login,email,password,confPass,cat);
	      
	      req.setAttribute("requestProcessor", reqProc);
	      req.setAttribute("message","Succes");
	      getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);
	      
	      req.removeAttribute("category");
	      req.setAttribute("category",cat);
	      categoyU=cat;
	      
	    } catch (DonneesInvalidesException e) {
	      req.setAttribute("message","Error <br><br>"+e.getMessage());
	      getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);
	    }
	  }
}

