package by.edu.grsu.air_company.dao.table;

import java.util.ArrayList;
import java.util.List;

import by.edu.grsu.air_company.entity.Race;

public class RaceTable extends AbstractTable<Race> {
	private static final long serialVersionUID = 5441172414587851076L;
	
	private List<Race> rows;
	
	@Override
	public List<Race> getRows() {
		if (rows == null) {
			rows = new ArrayList<Race>();
		}
		return rows;
	}

	@Override
	public void setRows(List<Race> rows) {
		this.rows = rows;		
	}

}
