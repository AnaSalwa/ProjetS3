package com.JAVA.DAO;


import java.util.List;
import com.JAVA.Bean.*;




public interface offreDAO {
	offre getById(int id);
    List<offre> getAll();
    void insert(offre offre);
    void update(offre offre);
    void delete(int id);
}