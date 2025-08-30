package com.JAVA.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.JAVA.Bean.*;
import com.JAVA.DAO.*;


import java.io.IOException;

/**
 * Servlet implementation class offreServlet
 */

public class offreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public offreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null; // Initialiser la connexion
	    offre offre = null;
		try {
			conn = offreConnexion.getConnection(); 
			offreDAO offreDAO = new offreDAOImpl(conn);
			String action = request.getParameter("action");

	        if (action == null || action.equals("list")) {
	            // Liste des offres
	            List<offre> offres = offreDAO.getAll();
	            request.setAttribute("offres", offres);
//	            request.getRequestDispatcher("indexc.jsp").forward(request, response);
	            request.getRequestDispatcher("MesOffres.jsp").forward(request, response);

	            
	            
	        }else  if (action == null || action.equals("listOffre")) {
	            // Liste des offres
	            List<offre> offres = offreDAO.getAll();
	            request.setAttribute("offres", offres);
	            request.getRequestDispatcher("ListeOffre.jsp").forward(request, response);
//	            request.getRequestDispatcher("MesOffres.jsp").forward(request, response);

	            
	            
	        } else if (action.equals("ajout")) {
	            // Afficher le formulaire d'ajout de offre
	            request.getRequestDispatcher("AjouterOffre.jsp").forward(request, response);
	            
	            
	        } else if (action.equals("edit")) {
	            // Récupérer l'ID du offre à éditer depuis les paramètres de la requête
	            int offreId = Integer.parseInt(request.getParameter("id"));

	            // Récupérer les données du offre depuis la base de données
	            offre = offreDAO.getById(offreId);

	            // Placer le offre dans la portée de la requête
	            request.setAttribute("offre", offre);

	            // Afficher le formulaire d'édition de offre
	            request.getRequestDispatcher("index3.jsp").forward(request, response);
	            
	            
	            
	            
	        } else if (action.equals("supprimer")) {
	            // Récupérer l'ID du offre à supprimer depuis les paramètres de la requête
	            int offreId = Integer.parseInt(request.getParameter("id"));

	            // Supprimer le offre de la base de données
	            offreDAO.delete(offreId);

	            // Rediriger vers la liste des offres
	            response.sendRedirect("offreServlet?action=list");
	            
	            
	            
	        }else if (action.equals("consulterOffre")){
	            int offreId = Integer.parseInt(request.getParameter("id"));
	          
	            offre = offreDAO.getById(offreId);
	            request.setAttribute("offre", offre);
	            request.getRequestDispatcher("ConsulterOffre.jsp").forward(request, response);
	            
	            
	            

	        }else if (action.equals("postulerOffre")) {
	        	int offreId = Integer.parseInt(request.getParameter("id")); // Récupérer l'ID de l'offre depuis les paramètres de la requête

	            // Stocker l'ID de l'offre dans la session
	            HttpSession session = request.getSession();
	            session.setAttribute("id_offre", offreId);
	            

	            // Afficher le formulaire d'ajout de offre
	            request.getRequestDispatcher("PostulerOffre.jsp").forward(request, response);}
	    

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Connection conn = null; // Initialiser la connexion
	    offre offre = null;
		try {
			conn = offreConnexion.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		

		offreDAO offreDAO = new offreDAOImpl(conn);
		
		
		
		
        if (action.equals("ajouterOffre")) {
            int id_recruteur= Integer.parseInt(request.getParameter("id_recruteur"));
            String titre = request.getParameter("titre");
            String poste = request.getParameter("poste");
            String mode = request.getParameter("mode");
            String date = request.getParameter("date");

            // Créer un nouveau offre avec les données
            offre newoffre = new offre(id_recruteur,titre, poste, mode, date);

            // Ajouter le offre à la base de données
            offreDAO.insert(newoffre);

            // Rediriger vers la liste des offres
            response.sendRedirect("offreServlet?action=list");
            
            
            
        } else if (action.equals("editer")) {
            // Récupérer les données du formulaire d'édition
            int offreId = Integer.parseInt(request.getParameter("id"));
            String titre = request.getParameter("titre");
            String poste = request.getParameter("poste");
            String mode = request.getParameter("mode");
            String date = request.getParameter("date");

            // Mettre à jour le offre dans la base de données
            offre updatedoffre = new offre(offreId, titre, poste, mode, date);
            offreDAO.update(updatedoffre);

            // Rediriger vers la liste des offres
            response.sendRedirect("offreServlet?action=list");
        }
        
	}

}