package com.JAVA.DAO;

import com.JAVA.Bean.*;

public interface userDAO {
	user login(String email, String password);
    boolean insert(user user);
    static user getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}

