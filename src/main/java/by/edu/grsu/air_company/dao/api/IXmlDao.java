package by.edu.grsu.air_company.dao.api;

import java.util.List;

public interface IXmlDao<E> {
	void saveNew(E entity);

	void update(E entity);

	E get(Integer id);

	List<E> getAll();

	void delete(Integer id);
}
