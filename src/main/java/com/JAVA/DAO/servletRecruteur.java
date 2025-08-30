package com.JAVA.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.JAVA.Bean.CandidatBean;
import com.JAVA.Bean.RecruteurBean;

/**
 * Servlet implementation class servletRecruteur
 */
public class servletRecruteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletRecruteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        
        if (action.equals("delete")) {
            // Récupérez le nom de l'utilisateur à partir de l'URL
            String nom = request.getParameter("nom");
            System.out.println("Valeur de nom : " + nom);


            if (nom != null && !nom.isEmpty()) {
                try {
                    RecruteurDaoImpl test = new RecruteurDaoImpl(DAOFactory.getInstance());
                    test.delete(nom); // Supprime l'utilisateur par nom
                    request.setAttribute("message", "Utilisateur supprimé avec succès");
                } catch (DAOException e) {
                    request.setAttribute("error", "Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
                }
            } else {
                request.setAttribute("error", "Le nom d'utilisateur ne peut pas être vide.");
            }

            this.getServletContext().getRequestDispatcher("/DeleteRecruteurResponse.jsp").forward(request, response);
       

        	    
        	    // ...
       } else if (action.equals("insert")) {
    	    String nom = request.getParameter("nom");
    	    String prenom = request.getParameter("prenom");
    	    String email = request.getParameter("email");
    	    String password = request.getParameter("password");
    	    String entreprise = request.getParameter("entreprise");


    	    if (nom != null && prenom != null && email != null && password != null && entreprise != null) {
    	        try {
    	            RecruteurDaoImpl test = new RecruteurDaoImpl(DAOFactory.getInstance());

    	            // Créez un objet PersonBean avec les informations de l'utilisateur
    	            RecruteurBean newUser = new RecruteurBean(0, nom, prenom,email,password,entreprise);

    	            // Appelez la méthode insert pour ajouter l'utilisateur
    	            test.insert(newUser);

    	            // Redirigez vers une page de confirmation avec un message de succès
    	            request.setAttribute("message", "Utilisateur ajouté avec succès");
    	        } catch (DAOException e) {
    	            // Gérez les erreurs de la couche DAO
    	            request.setAttribute("error", "Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
    	        }
    	    } else {
    	        // Gérez le cas où des informations obligatoires sont manquantes dans la requête
    	        request.setAttribute("error", "Informations d'utilisateur manquantes dans la requête");
    	    }

    	    this.getServletContext().getRequestDispatcher("/DashboardRecruteur.jsp").forward(request, response);
    	
 
        	    
        	    
        	    
        	    
        	    // ...
       }else if (action.equals("find")) {
    	   
    	   		String nom = request.getParameter("nom");

            	RecruteurDaoImpl test = new RecruteurDaoImpl( DAOFactory.getInstance()) ;
        		
        		request.setAttribute( "personnes" , test.find(nom) );
        		
        		this.getServletContext().getRequestDispatcher("/FindRecruteurResponse.jsp").forward( request, response );
        		
       }else if (action.equals("update")) {
//        		    String nom = request.getParameter("nom");
//        		    String prenom = request.getParameter("prenom");
//        		    int age = Integer.parseInt(request.getParameter("age"));
//        		    String email = request.getParameter("email");
//
//        		    if (nom != null && prenom != null && email != null) {
//        		        try {
//        		            PersonDaoImpl test = new PersonDaoImpl(DAOFactory.getInstance());
//
//        		            // Créez un objet PersonBean avec les nouvelles informations de l'utilisateur
//        		            PersonBean updatedUser = new PersonBean(0, nom, prenom, age, email);
//
//        		            // Appelez la méthode update pour mettre à jour l'utilisateur
//        		            test.update(updatedUser);
//
//        		            // Redirigez vers une page de confirmation avec un message de succès
//        		            request.setAttribute("message", "Utilisateur mis à jour avec succès");
//        		        } catch (DAOException e) {
//        		            // Gérez les erreurs de la couche DAO
//        		            request.setAttribute("error", "Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
//        		        }
//        		    } else {
//        		        // Gérez le cas où des informations obligatoires sont manquantes dans la requête
//        		        request.setAttribute("error", "Informations d'utilisateur manquantes dans la requête");
//        		    }
//
//        		    this.getServletContext().getRequestDispatcher("/Update.jsp").forward(request, response);
        		

        		
        		
        		
        		
       } else if (action.equals("all")) {
            	RecruteurDaoImpl test = new RecruteurDaoImpl( DAOFactory.getInstance()) ;
        		
        		request.setAttribute( "personnes" , test.getall() );
        		
        		this.getServletContext().getRequestDispatcher("/Recruteur.jsp").forward( request, response ); 
        		
        	
           
    	}else if (action.equals("loginRecruteur")) {
    		
    		  String email = request.getParameter("email");
              String password = request.getParameter("password");

              // Validation des paramètres (à adapter selon vos besoins)
              if (email != null && password != null) {
                  RecruteurDaoImpl recruteurDao = new RecruteurDaoImpl(DAOFactory.getInstance());  // Vous devez obtenir cette instance d'une manière appropriée

                  RecruteurBean recruteur = recruteurDao.loginRecruteur(email, password);

                  if (recruteur != null) {
                      // L'authentification a réussi, vous pouvez rediriger ou effectuer d'autres actions ici
                      request.getSession().setAttribute("recruteur", recruteur);
                      response.sendRedirect("DashboardRecruteur.jsp"); // Redirigez vers la page d'accueil des recruteurs
                  } else {
                      // L'authentification a échoué, vous pouvez rediriger vers une page d'erreur ou effectuer d'autres actions
                      response.sendRedirect("echecConnexion.jsp");
                  }
              } else {
              
              }
    	}


        // Redirigez l'utilisateur vers la page appropriée en fonction de l'action
    	else if (action != null) {
            this.getServletContext().getRequestDispatcher("/" + action + ".jsp").forward(request, response);
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
