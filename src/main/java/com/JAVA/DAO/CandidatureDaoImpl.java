package com.JAVA.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JAVA.Bean.CandidatureBean;
import com.JAVA.Bean.RecruteurBean;
import com.JAVA.Bean.offre;

public class CandidatureDaoImpl {
	private Connection connection;
//	private Connection con = Getconnexion.getConnection();
	


	private DAOFactory          daoFactory;

    public CandidatureDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	public CandidatureDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void create(CandidatureBean Candidature) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	private static CandidatureBean map( ResultSet resultSet ) throws SQLException {
			CandidatureBean CandidatureBean = new CandidatureBean();
			CandidatureBean.setId((int)resultSet.getLong( "id" ) );
			CandidatureBean.setId_candidat((int)resultSet.getLong( "id_candidat" ) );
			CandidatureBean.setId_offre((int)resultSet.getLong( "id_offre" ) );
			CandidatureBean.setMotivation( resultSet.getString( "motivation" ) );

			return CandidatureBean;
	}
	
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
		    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
		    for ( int i = 0; i < objets.length; i++ ) {
		        preparedStatement.setObject( i + 1, objets[i] );
		    }
		    return preparedStatement;
	}
	
	
	
//	public CandidatureBean[] getAll() throws DAOException {
//	    final String SQL_SELECT_PAR_NOM = "SELECT * FROM candidature ";
//	    
//	    Connection connexion = null;
//	    PreparedStatement preparedStatement = null;
//	    ResultSet resultSet = null;
//	    List<CandidatureBean> candidatureList = new ArrayList<>(); 
//
//	    try {
//	        /* Récupération d'une connexion depuis la Factory */
//	        connexion = daoFactory.getConnection();
//	        preparedStatement = initRequestPrepare(connexion, SQL_SELECT_PAR_NOM);
//	        resultSet = preparedStatement.executeQuery();
//	        
//	        /* Parcours des lignes de données du ResultSet */
//	        int count = 0;
//	        while (resultSet.next() ) {
//	            int id = resultSet.getInt("id");
//	            int id_candidat = resultSet.getInt("id_candidat");
//	            int id_offre = resultSet.getInt("id_offre");
//	            String motivation = resultSet.getString("motivation");
//
//
//	            CandidatureBean candidature = new CandidatureBean(id, id_candidat, id_offre, motivation);
//	            candidatureList.add(candidature); // Ajoutez chaque personne à la liste
//	            count++;
//	        }
//	    } catch (SQLException e) {
//	        throw new DAOException(e);
//	    } finally {
//	        // ClosingAll(resultSet, preparedStatement, connexion);
//	    }
//
//	   CandidatureBean[] candidatureBeans = candidatureList.toArray(new CandidatureBean[0]);
//	    return candidatureBeans;
//	}
	
    public List<CandidatureBean> getAll() {
        List<CandidatureBean> candidatures= new ArrayList<>();
        String sql = "SELECT * FROM candidature";

		try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                CandidatureBean candidature = new CandidatureBean();
                
                candidature.setId(resultSet.getInt("id"));
                candidature.setId_candidat(resultSet.getInt("id_candidat"));
                candidature.setId_offre(resultSet.getInt("id_offre"));
                candidature.setMotivation(resultSet.getString("motivation"));

                candidatures.add(candidature);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return candidatures;
    }
    
    
    
    public CandidatureBean[] getallCandidatures(int idCandidatConnecte) throws DAOException {
        final String SQL_SELECT_PAR_CANDIDAT = "SELECT * FROM candidature WHERE id_candidat = ?";
        
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CandidatureBean> candidatureList = new ArrayList<>();

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initRequestPrepare(connexion, SQL_SELECT_PAR_CANDIDAT);
            preparedStatement.setInt(1, idCandidatConnecte);
            resultSet = preparedStatement.executeQuery();
            
            int count = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_candidat = resultSet.getInt("id_candidat");
                int id_offre = resultSet.getInt("id_offre");
                String motivation = resultSet.getString("motivation");

                CandidatureBean candidature = new CandidatureBean(id, id_candidat, id_offre, motivation);
                candidatureList.add(candidature);
                count++;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            // ClosingAll(resultSet, preparedStatement, connexion);
        }

        CandidatureBean[] candidatureBeans = candidatureList.toArray(new CandidatureBean[0]);
        return candidatureBeans;
    }

    
    
    public 	CandidatureBean[] getallCandidatures() throws DAOException {
	    final String SQL_SELECT_PAR_NOM = "SELECT * FROM candidature ";
	    
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<CandidatureBean> candidatureList = new ArrayList<>(); // Utilisez une liste pour stocker les personnes

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare(connexion, SQL_SELECT_PAR_NOM);
	        resultSet = preparedStatement.executeQuery();
	        
	        /* Parcours des lignes de données du ResultSet */
	        int count = 0;
	        while (resultSet.next() ) {
	            int id = resultSet.getInt("id");
	            int id_candidat = resultSet.getInt("id_candidat");
	            int id_offre = resultSet.getInt("id_offre");
	            String motivation = resultSet.getString("motivation");


	            CandidatureBean candidature = new CandidatureBean(id, id_candidat,id_offre, motivation);
	            candidatureList.add(candidature); // Ajoutez chaque personne à la liste
	            count++;
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	        // ClosingAll(resultSet, preparedStatement, connexion);
	    }

	    CandidatureBean[] candidatureBeans = candidatureList.toArray(new CandidatureBean[0]);
	    return candidatureBeans;
	}
    

	
	
	
	public  void  delete(String id) throws DAOException {
	    final String SQL_DELETE = "DELETE FROM candidature WHERE nom = ?";

	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = connexion.prepareStatement(SQL_DELETE);
	        preparedStatement.setString(1, id); // Utilisez l'ID de l'utilisateur à supprimer
	        preparedStatement.executeUpdate(); // Exécute la suppression
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	        // ClosingAll(preparedStatement, connexion);
	    }
	}

	public void insert(CandidatureBean user) {
		  final String SQL_INSERT = "INSERT INTO candidature ( id_candidat,id_offre,motivation) VALUES (?,?, ?)";

		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = connexion.prepareStatement(SQL_INSERT);
		        preparedStatement.setInt(1, user.getId_candidat());
		        preparedStatement.setInt(2, user.getId_offre());
		        preparedStatement.setString(3, user.getMotivation());
		        preparedStatement.executeUpdate(); // Exécute l'insertion
		    } catch (SQLException e) {
		        throw new DAOException(e);
		    } finally {
		        // ClosingAll(preparedStatement, connexion);
		    }
		}


	
//	public RecruteurBean find(String nom) throws DAOException {
//		// TODO Auto-generated method stub
//		    final String SQL_SELECT_PAR_NOM = "SELECT id, nom, prenom,email,entreprise FROM recruteur WHERE nom = ?";
//		    Connection connexion = null;
//		    PreparedStatement preparedStatement = null;
//		    ResultSet resultSet = null;
//		    RecruteurBean recruteurBean = null;
//
//		    try {
//		        /* Récupération d'une connexion depuis la Factory */
//		        connexion = daoFactory.getConnection();
//		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, nom );
//		        resultSet = preparedStatement.executeQuery();
//		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
//		        if ( resultSet.next() ) {
//		            recruteurBean = map( resultSet );
//		        }
//		    } catch ( SQLException e ) {
//		        throw new DAOException( e );
//		    } finally {
//		        //ClosingAll( resultSet, preparedStatement, connexion );
//		    }
//
//		    return recruteurBean;
//		}
	
	
	 public RecruteurBean loginRecruteur(String email, String password) {
	        RecruteurBean recruteur = null;
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = daoFactory.getConnection();

	            String query = "SELECT * FROM recruteur WHERE email = ? AND password = ?";
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	            resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                recruteur = new RecruteurBean();
	                recruteur.setId(resultSet.getInt("id"));
	                recruteur.setEmail(resultSet.getString("email"));
	                // Ajoutez d'autres propriétés si nécessaire
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
//	            closeResources(resultSet, preparedStatement, connection);
	        }

	        return recruteur;
	    }

	 
	   public void delete(int id) {
	        String SQL_DELETE = "DELETE FROM candidature WHERE id = ?";
	        Connection connexion = null;
		    PreparedStatement preparedStatement = null;

	        try  {
	        	
	            connexion = daoFactory.getConnection();
		        preparedStatement = connexion.prepareStatement(SQL_DELETE);
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	
	


}
