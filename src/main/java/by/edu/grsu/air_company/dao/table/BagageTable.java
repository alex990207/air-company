package by.edu.grsu.air_company.dao.table;

import java.util.ArrayList;
import java.util.List;

import by.edu.grsu.air_company.entity.Bagage;

public class BagageTable extends AbstractTable<Bagage> {
	private static final long serialVersionUID = 5441172414587851076L;
	
	private List<Bagage> rows;
	
	@Override
	public List<Bagage> getRows() {
		if (rows == null) {
			rows = new ArrayList<Bagage>();
		}
		return rows;
	}

	@Override
	public void setRows(List<Bagage> rows) {
		this.rows = rows;		
	}

}
