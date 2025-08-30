package com.JAVA.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.JAVA.DAO.*;
import com.JAVA.Bean.*;

public class userDAOImpl implements userDAO {
    private final Connection connection;

    public userDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public user login(String email, String password) {
        user user = null;
        String sql = "SELECT * FROM candidat WHERE email = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new user();
                    user.setId(resultSet.getInt("id"));
                    user.setEmail(resultSet.getString("email"));
                    // Ne stockez jamais les mots de passe en clair dans la base de données.
                    // Utilisez des techniques sécurisées telles que le hachage et le salage.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    // Implémentez d'autres méthodes DAO au besoin

	@Override
	public boolean insert(user user) {
		// TODO Auto-generated method stub
		return false;
	}
}


