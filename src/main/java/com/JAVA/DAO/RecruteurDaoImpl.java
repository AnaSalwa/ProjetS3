package com.JAVA.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.JAVA.Bean.RecruteurBean;

public class RecruteurDaoImpl {
	

		private DAOFactory          daoFactory;

	    public RecruteurDaoImpl( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	    }
	    
		public RecruteurDaoImpl() {
			// TODO Auto-generated constructor stub
		}

		public void create(RecruteurBean Candidat) throws DAOException {
			// TODO Auto-generated method stub
			
		}
		
		private static RecruteurBean map( ResultSet resultSet ) throws SQLException {
				RecruteurBean RecruteurBean = new RecruteurBean();
				RecruteurBean.setId((int)resultSet.getLong( "id" ) );
				RecruteurBean.setNom( resultSet.getString( "nom" ) );
				RecruteurBean.setEmail( resultSet.getString( "email" ) );
				RecruteurBean.setPrenom( resultSet.getString( "prenom" ) );
				RecruteurBean.setEntreprise( resultSet.getString( "entreprise" ) );

				return RecruteurBean;
		}
		
		
		public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
			    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
			    for ( int i = 0; i < objets.length; i++ ) {
			        preparedStatement.setObject( i + 1, objets[i] );
			    }
			    return preparedStatement;
		}
		
		
		
		public RecruteurBean[] getall() throws DAOException {
		    final String SQL_SELECT_PAR_NOM = "SELECT * FROM recruteur ";
		    
		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    List<RecruteurBean> recruteurList = new ArrayList<>(); // Utilisez une liste pour stocker les personnes

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
		            String password = resultSet.getString("password");
		            String entreprise = resultSet.getString("entreprise");


		            RecruteurBean recruteur = new RecruteurBean(id, nom, prenom, email,password, entreprise);
		            recruteurList.add(recruteur); // Ajoutez chaque personne à la liste
		            count++;
		        }
		    } catch (SQLException e) {
		        throw new DAOException(e);
		    } finally {
		        // ClosingAll(resultSet, preparedStatement, connexion);
		    }

		    RecruteurBean[] candidatBeans = recruteurList.toArray(new RecruteurBean[0]);
		    return candidatBeans;
		}

		
		
		
		public  void  delete(String nom) throws DAOException {
		    final String SQL_DELETE = "DELETE FROM recruteur WHERE nom = ?";

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

		public void insert(RecruteurBean user) {
			  final String SQL_INSERT = "INSERT INTO recruteur (nom, prenom,email,password,entreprise) VALUES (?,?,?, ?, ?)";

			    Connection connexion = null;
			    PreparedStatement preparedStatement = null;

			    try {
			        /* Récupération d'une connexion depuis la Factory */
			        connexion = daoFactory.getConnection();
			        preparedStatement = connexion.prepareStatement(SQL_INSERT);
			        preparedStatement.setString(1, user.getNom());
			        preparedStatement.setString(2, user.getPrenom());
			        preparedStatement.setString(3, user.getPassword());
			        preparedStatement.setString(4, user.getEmail());
			        preparedStatement.setString(5, user.getEntreprise());
			        preparedStatement.executeUpdate(); // Exécute l'insertion
			    } catch (SQLException e) {
			        throw new DAOException(e);
			    } finally {
			        // ClosingAll(preparedStatement, connexion);
			    }
			}


		
		public RecruteurBean find(String nom) throws DAOException {
			// TODO Auto-generated method stub
			    final String SQL_SELECT_PAR_NOM = "SELECT id, nom, prenom,email,entreprise FROM recruteur WHERE nom = ?";
			    Connection connexion = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;
			    RecruteurBean recruteurBean = null;

			    try {
			        /* Récupération d'une connexion depuis la Factory */
			        connexion = daoFactory.getConnection();
			        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, nom );
			        resultSet = preparedStatement.executeQuery();
			        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			        if ( resultSet.next() ) {
			            recruteurBean = map( resultSet );
			        }
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			        //ClosingAll( resultSet, preparedStatement, connexion );
			    }

			    return recruteurBean;
			}
		
		
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
//		            closeResources(resultSet, preparedStatement, connection);
		        }

		        return recruteur;
		    }


		
		


}
