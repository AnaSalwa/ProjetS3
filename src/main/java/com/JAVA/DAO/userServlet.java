package com.JAVA.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class userServlet
 */

import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.SQLException;
import com.JAVA.Bean.*;
import com.JAVA.DAO.*;



public class userServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private userDAO userDAO;
    public void init() {
        try {
			userDAO = new userDAOImpl(userConnexion.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        user user = userDAO.login(email, password);

        if (user != null) {
        	    int id_candidat = user.getId();
	            HttpSession session = request.getSession();
	            session.setAttribute("id_candidat", id_candidat);
            // L'utilisateur est authentifié avec succès
            // Redirigez vers la page d'accueil ou autre page autorisée
        	response.sendRedirect("offreServlet?action=list");
        } else {
            // Identifiants invalides, afficher un message d'erreur
            request.setAttribute("error", "Invalid credentials");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}



