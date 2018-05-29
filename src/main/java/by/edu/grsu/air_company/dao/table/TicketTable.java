package by.edu.grsu.air_company.dao.table;

import java.util.ArrayList;
import java.util.List;

import by.edu.grsu.air_company.entity.Ticket;

public class TicketTable  extends AbstractTable<Ticket> {
	private static final long serialVersionUID = 5441172414587851076L;
	
	private List<Ticket> rows;
	
	@Override
	public List<Ticket> getRows() {
		if (rows == null) {
			rows = new ArrayList<Ticket>();
		}
		return rows;
	}

	@Override
	public void setRows(List<Ticket> rows) {
		this.rows = rows;		
	}

}
