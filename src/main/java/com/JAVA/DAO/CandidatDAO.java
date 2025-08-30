package com.JAVA.DAO;

import com.JAVA.Bean.CandidatBean;

public interface CandidatDAO {

	 void create( CandidatBean candidat ) throws DAOException;

	 CandidatBean find( String nom ) throws DAOException;
	 
	 CandidatBean[] getall() throws DAOException;

	 void delete(int id) throws DAOException;

	 void delete(String nom) throws DAOException;
}
