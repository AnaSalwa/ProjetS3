package com.JAVA.DAO;


import com.JAVA.DAO.*;
import com.JAVA.Bean.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class offreDAOImpl implements offreDAO{
	
	private Connection connection;
//	private Connection con = Getconnexion.getConnection();
	public offreDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public offre getById(int id) {

        offre offre = null;
        String sql = "SELECT * FROM offre WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                offre = new offre();
                offre.setId(resultSet.getInt("id"));
                offre.setTitre(resultSet.getString("titre"));
                offre.setPoste(resultSet.getString("poste"));
                offre.setMode(resultSet.getString("mode"));
                offre.setDate(resultSet.getString("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return offre;
    }
    
    
    @Override
    
    public List<offre> getAll() {
        List<offre> offres = new ArrayList<>();
        String sql = "SELECT * FROM offre";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                offre offre = new offre();
                offre.setId(resultSet.getInt("id"));
                offre.setTitre(resultSet.getString("titre"));
                offre.setPoste(resultSet.getString("poste"));
                offre.setMode(resultSet.getString("mode"));
                offre.setDate(resultSet.getString("date"));

                offres.add(offre);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return offres;
    }

    
    
    
    
    @Override
    public void insert(offre offre) {
        String sql = "INSERT INTO offre (id_recruteur, titre, poste, mode, date) VALUES (?,?,?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, offre.getId_recruteur());
            statement.setString(2, offre.getTitre());
            statement.setString(3, offre.getPoste());
            statement.setString(4, offre.getMode());
            statement.setString(5, offre.getDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    @Override
    public void update(offre offre) {
        String sql = "UPDATE offre SET titre = ?, poste = ?, mode = ?, date = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, offre.getTitre());
            statement.setString(2, offre.getPoste());
            statement.setString(3, offre.getMode());
            statement.setString(4, offre.getDate());
            statement.setInt(5, offre.getId());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    
    
    
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM offre WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
  

	

}