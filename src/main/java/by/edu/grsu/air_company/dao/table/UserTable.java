package by.edu.grsu.air_company.dao.table;

import java.util.ArrayList;
import java.util.List;

import by.edu.grsu.air_company.entity.User;

public class UserTable  extends AbstractTable<User> {
	private static final long serialVersionUID = 5441172414587851076L;
	
	private List<User> rows;
	
	@Override
	public List<User> getRows() {
		if (rows == null) {
			rows = new ArrayList<User>();
		}
		return rows;
	}

	@Override
	public void setRows(List<User> rows) {
		this.rows = rows;		
	}

}
