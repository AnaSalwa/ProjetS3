package com.JAVA.DAO;

import com.JAVA.Bean.*;

public interface RecruteurDAO {


	 void create( RecruteurBean candidat ) throws DAOException;

	 RecruteurBean find( String nom ) throws DAOException;
	 
	 RecruteurBean[] getall() throws DAOException;

	 void delete(int id) throws DAOException;

	 void delete(String nom) throws DAOException;
	 
	 void loginRecruiter(String email,String password) throws DAOException;
}
