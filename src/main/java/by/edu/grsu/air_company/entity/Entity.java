package by.edu.grsu.air_company.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable {
	private static final long serialVersionUID = -5289687133453602981L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + id;
	}
	
}
