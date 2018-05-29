package by.edu.grsu.air_company.dao.table;

import java.io.Serializable;
import java.util.List;

import by.edu.grsu.air_company.entity.Entity;

public abstract class AbstractTable<E> implements Serializable {
	private static final long serialVersionUID = 7613615167475476062L;

	public abstract List<E> getRows();

	public abstract void setRows(final List<E> rows);
	
	public int getMaxId() {
		int maxId = 0;
		for(E e : getRows()) {
			Entity entity = (Entity)e;
			if(maxId < entity.getId()) {
				maxId = entity.getId();
			}
		}
		return maxId;
	}
}