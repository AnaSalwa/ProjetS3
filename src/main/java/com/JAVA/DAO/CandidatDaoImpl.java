package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JAVA.Bean.CandidatBean;
import com.JAVA.Bean.RecruteurBean;

public class CandidatDaoImpl {
	
	private DAOFactory          daoFactory;

    public CandidatDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	public CandidatDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void create(CandidatBean Candidat) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private static CandidatBean map( ResultSet resultSet ) throws SQLException {
			CandidatBean CandidatBean = new CandidatBean();
			CandidatBean.setId((int)resultSet.getLong( "id" ) );
			CandidatBean.setNom( resultSet.getString( "nom" ) );
			CandidatBean.setEmail( resultSet.getString( "email" ) );
			CandidatBean.setPrenom( resultSet.getString( "prenom" ) );
			return CandidatBean;
	}
	
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
		    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
		    for ( int i = 0; i < objets.length; i++ ) {
		        preparedStatement.setObject( i + 1, objets[i] );
		    }
		    return preparedStatement;
	}
	
	public CandidatBean find(String nom) throws DAOException {
		// TODO Auto-generated method stub
		
		
		    final String SQL_SELECT_PAR_NOM = "SELECT id, nom, prenom,email FROM candidat WHERE nom = ?";
		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    CandidatBean candidatBean = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, nom );
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {
		            candidatBean = map( resultSet );
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }

		    return candidatBean;
		}
	
	
	
	
	public CandidatBean[] getall() throws DAOException {
	    final String SQL_SELECT_PAR_NOM = "SELECT * FROM candidat ";
	    
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<CandidatBean> candidatList = new ArrayList<>(); // Utilisez une liste pour stocker les personnes

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare(connexion, SQL_SELECT_PAR_NOM);
	        resultSet = preparedStatement.executeQuery();
	        
	        /* Parcours des lignes de données du ResultSet */
	        int count = 0;
	        while (resultSet.next() ) {
	            int id = resultSet.getInt("id");
	            String nom = resultSet.getString("nom");
	            String prenom = resultSet.getString("prenom");
	            String email = resultSet.getString("email");

	            CandidatBean candidat = new CandidatBean(id, nom, prenom, email);
	            candidatList.add(candidat); // Ajoutez chaque personne à la liste
	            count++;
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	        // ClosingAll(resultSet, preparedStatement, connexion);
	    }

	    CandidatBean[] candidatBeans = candidatList.toArray(new CandidatBean[0]);
	    return candidatBeans;
	}

	
	public  void  delete(String nom) throws DAOException {
	    final String SQL_DELETE = "DELETE FROM candidat WHERE nom = ?";

	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = connexion.prepareStatement(SQL_DELETE);
	        preparedStatement.setString(1, nom); // Utilisez l'ID de l'utilisateur à supprimer
	        preparedStatement.executeUpdate(); // Exécute la suppression
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	        // ClosingAll(preparedStatement, connexion);
	    }
	}

	public void insert(CandidatBean user) {
		  final String SQL_INSERT = "INSERT INTO candidat (nom, prenom,email,password) VALUES (?,?, ?, ?)";

		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = connexion.prepareStatement(SQL_INSERT);
		        preparedStatement.setString(1, user.getNom());
		        preparedStatement.setString(2, user.getPrenom());
		        preparedStatement.setString(4, user.getPassword());
		        preparedStatement.setString(3, user.getEmail());
		        preparedStatement.executeUpdate(); // Exécute l'insertion
		    } catch (SQLException e) {
		        throw new DAOException(e);
		    } finally {
		        // ClosingAll(preparedStatement, connexion);
		    }
		}
	
	

	 public CandidatBean loginCandidat(String email, String password) {
	       	CandidatBean candidat = null;
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        try {
	            connection = daoFactory.getConnection();

	            String query = "SELECT * FROM candidat WHERE email = ? AND password = ?";
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                candidat = new CandidatBean();
	                candidat.setId(resultSet.getInt("id"));
	                candidat.setEmail(resultSet.getString("email"));
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	        }

	        return candidat;
	    }



	
	
	
	
	

}
