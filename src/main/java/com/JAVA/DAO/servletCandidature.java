package com.JAVA.DAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.JAVA.Bean.CandidatBean;
import com.JAVA.Bean.CandidatureBean;
import com.JAVA.Bean.RecruteurBean;
import com.JAVA.Bean.offre;

/**
 * Servlet implementation class servletCandidature
 */
public class servletCandidature extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCandidature() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
		 
	
		 
		 if (action.equals("supprimerCandidature")) {
	           
			
	            CandidatureDaoImpl candidature = new CandidatureDaoImpl(DAOFactory.getInstance());
	            int id = Integer.parseInt(request.getParameter("id"));

	            // Supprimer le offre de la base de données
	            candidature.delete(id);

	            // Rediriger vers la liste des offres
	            response.sendRedirect("DashboardCandidat.jsp");
	       

	        	    
	        	    // ...
	       }else if (action.equals("AjouterCandidature")) {
	    	   int id_offre = Integer.parseInt(request.getParameter("id_offre"));
	    	    int id_candidat = Integer.parseInt(request.getParameter("id_candidat"));
	    	    String motivation = request.getParameter("motivation");

//	    	    request.setAttribute("id_offre", id_offre);
	    	    request.setAttribute("id_candidat", id_candidat);
	    	    request.setAttribute("id_candidat", id_offre);
	    	    request.setAttribute("motivation", motivation);  // Ajout de la motivation aux attributs

	    	    // Forward the request to the JSP page
	    	 

	    	    if (motivation != null) {
	    	        try {
	    	            CandidatureDaoImpl test = new CandidatureDaoImpl(DAOFactory.getInstance());

	    	            // Créez un objet CandidatureBean avec les informations de la candidature
	    	            CandidatureBean candidature = new CandidatureBean(0, id_candidat, id_offre, motivation);

	    	            // Appelez la méthode insert pour ajouter la candidature
	    	            test.insert(candidature);

	    	            // Redirigez vers une page de confirmation avec un message de succès
	    	            request.setAttribute("message", "Candidature ajoutée avec succès");
	    	        } catch (DAOException e) {
	    	            // Gérez les erreurs de la couche DAO
	    	            request.setAttribute("error", "Erreur lors de l'ajout de la candidature : " + e.getMessage());
	    	        }
	    	    }
	    	
	       		else {
	    	        // Gérez le cas où des informations obligatoires sont manquantes dans la requête
	    	        request.setAttribute("error", "Informations d'utilisateur manquantes dans la requête");
	    	    }

	    	    this.getServletContext().getRequestDispatcher("/DashboardCandidat.jsp").forward(request, response);
	    	
	 
	        	    
	        	    
	        	    
		    
	        	    // ...
	       }else if (action.equals("find")) {
	    	   
	    	   		String nom = request.getParameter("nom");

	            	RecruteurDaoImpl test = new RecruteurDaoImpl( DAOFactory.getInstance()) ;
	        		
	        		request.setAttribute( "personnes" , test.find(nom) );
	        		
	        		this.getServletContext().getRequestDispatcher("/FindRecruteurResponse.jsp").forward( request, response );
	        		
	       }else if (action.equals("update")) {
//	        		    String nom = request.getParameter("nom");
//	        		    String prenom = request.getParameter("prenom");
//	        		    int age = Integer.parseInt(request.getParameter("age"));
//	        		    String email = request.getParameter("email");
	//
//	        		    if (nom != null && prenom != null && email != null) {
//	        		        try {
//	        		            PersonDaoImpl test = new PersonDaoImpl(DAOFactory.getInstance());
	//
//	        		            // Créez un objet PersonBean avec les nouvelles informations de l'utilisateur
//	        		            PersonBean updatedUser = new PersonBean(0, nom, prenom, age, email);
	//
//	        		            // Appelez la méthode update pour mettre à jour l'utilisateur
//	        		            test.update(updatedUser);
	//
//	        		            // Redirigez vers une page de confirmation avec un message de succès
//	        		            request.setAttribute("message", "Utilisateur mis à jour avec succès");
//	        		        } catch (DAOException e) {
//	        		            // Gérez les erreurs de la couche DAO
//	        		            request.setAttribute("error", "Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
//	        		        }
//	        		    } else {
//	        		        // Gérez le cas où des informations obligatoires sont manquantes dans la requête
//	        		        request.setAttribute("error", "Informations d'utilisateur manquantes dans la requête");
//	        		    }
	//
//	        		    this.getServletContext().getRequestDispatcher("/Update.jsp").forward(request, response);
	        		

	        		
	        		
	        		
	        		
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
	                  // Gestion du cas où les paramètres requis sont nuls
//	                  response.sendRedirect("echecConnexion.jsp");
	              }
//	                String email = request.getParameter("emailaddress");
//	                String password = request.getParameter("password");
	//
//	                RecruteurDaoImpl recruteurDao = new RecruteurDaoImpl(DAOFactory.getInstance());
//	                RecruteurBean recruteur = recruteurDao.loginRecruteur(email, password);
	//
//	                if (recruteur != null) {
//	                    HttpSession session = request.getSession();
//	                    session.setAttribute("user", recruteur);
//	                    response.sendRedirect("Accueil.jsp");
//	                } else {
//	                    // L'authentification a échoué, redirigez vers une page d'échec de connexion
//	                    response.sendRedirect("echecConnexion.jsp");
//	                }
	           
	              
	        }else  if (action.equals("listCandidatures")) {
//	            List<CandidatureBean> candidatures = CandidatureDAO.getAll();
//	            request.setAttribute("candidatures", candidatures);
//	            request.getRequestDispatcher("MesCandidatures.jsp").forward(request, response);
////	            request.getRequestDispatcher("MesOffres.jsp").forward(request, response);
	        	
	        	CandidatureDaoImpl test = new CandidatureDaoImpl( DAOFactory.getInstance()) ;
        		
        		request.setAttribute( "candidatures" , test.getallCandidatures() );
        		
        		this.getServletContext().getRequestDispatcher("/MesCandidatures.jsp").forward( request, response ); 
        		

	            
	            
	        
	        
	    
	
			}else  if (action.equals("listCandidaturesParId")) {
			//    List<CandidatureBean> candidatures = CandidatureDAO.getAll();
			//    request.setAttribute("candidatures", candidatures);
			//    request.getRequestDispatcher("MesCandidatures.jsp").forward(request, response);
			////    request.getRequestDispatcher("MesOffres.jsp").forward(request, response);
		     int id_candidat = Integer.parseInt(request.getParameter("id_candidat"));

				CandidatureDaoImpl test = new CandidatureDaoImpl( DAOFactory.getInstance()) ;
				
				request.setAttribute( "candidatures" , test.getallCandidatures(id_candidat) );
				
				this.getServletContext().getRequestDispatcher("/MesCandidatures.jsp").forward( request, response ); 
				
			
			    
			    
			}else if (action != null) {
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
