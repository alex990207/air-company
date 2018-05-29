package by.edu.grsu.air_company.api.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {

	T get(ID id);
	
	List<T> getAll();
	
	void add(T entity);
	
	void update(T entity);
	
	void delete(T entity);	
}
