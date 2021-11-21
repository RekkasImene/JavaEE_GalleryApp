package controllers;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
    static File customerDataFile;
    List<String> categoryList= new ArrayList<String>();

    // array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
        "gif", "png", "bmp","jpg","jpeg","svg" // and other formats you need
    };
    
 // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };


    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	//dir = new File(config.getInitParameter("imagesFolder"));
    	
    	ServletContext context = getServletContext();
		
		Path directory = Paths.get(context.getRealPath(config.getInitParameter("imagesFolder")));
		

		try {
			Files.walk(directory, 1).filter(entry -> !entry.equals(directory))
		    .filter(Files::isDirectory).forEach(subdirectory ->
		    {
		    System.out.println(subdirectory.getFileName());
		    categoryList.add(subdirectory.getFileName().toString());
		    });
		} catch (IOException e) {
			 System.out.println("Fichier vide "+e.getMessage());
		}
		
		context.setAttribute("listCategory", categoryList);
    	
    }
    
    	public void contextInitialized(ServletContextEvent e) {

    	dir = new File(e.getServletContext().getInitParameter("imagesFolder"));
    	
    	System.out.println("name folder image : " + dir.toString());
    	
        customerDataFile = new File(dir, "/accordin/image_0001.jpg");
        
        if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                BufferedImage img = null;

                try {
                    img = ImageIO.read(f);

                    // you probably want something more involved here
                    // to display in your UI
                    System.out.println("image: " + f.getName());
                    System.out.println(" width : " + img.getWidth());
                    System.out.println(" height: " + img.getHeight());
                    System.out.println(" size  : " + f.length());
                } catch (final IOException E) {
                    // handle errors here
                }
            }
        }
    }
   
    



	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		getServletContext().getRequestDispatcher(VUE_RESULTAT).forward(req, resp);
		
		
	      
		
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
	      getServletContext().getRequestDispatcher(VUE_RESULTAT).forward(req, resp);
	    } catch (DonneesInvalidesException e) {
	      req.setAttribute("message","Error <br><br>"+e.getMessage());
	      getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);
	    }
	  }
}

