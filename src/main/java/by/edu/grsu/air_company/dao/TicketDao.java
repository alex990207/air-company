package by.edu.grsu.air_company.dao;

import java.util.List;

import by.edu.grsu.air_company.dao.table.TicketTable;
import by.edu.grsu.air_company.entity.Ticket;

public class TicketDao extends AbstractDao<TicketTable, Ticket> {

	public TicketDao(String rootFolderPath) {
		super(rootFolderPath);
	}

	public void saveNew(Ticket entity) {
		entity.setId(getNextId());
		final TicketTable table = deserializeFromXml();
		table.getRows().add(entity);
		serializeToXml(table);
	}

	public void update(Ticket entity) {
		final TicketTable table = deserializeFromXml();
		for (final Ticket ticket : table.getRows()) {
			if (ticket.getId().equals(entity.getId())) {
				ticket.setBagage(entity.getBagage());
				ticket.setBoughtDate(entity.getBoughtDate());
				ticket.setFirstAccessStatus(entity.getFirstAccessStatus());
				ticket.setPrice(entity.getPrice());
				ticket.setRace(entity.getRace());
				ticket.setUser(entity.getUser());
				serializeToXml(table);
				return;
			}
		}
	}

	public Ticket get(Integer id) {
		final TicketTable table = deserializeFromXml();
		for (final Ticket ticket : table.getRows()) {
			if (ticket.getId().equals(id)) {
				return ticket;
			}
		}
		return null;
	}

	public List<Ticket> getAll() {
		return deserializeFromXml().getRows();
	}

	public void delete(Integer id) {
		Ticket toBeDeleted = null;
		final TicketTable table = deserializeFromXml();
		for (Ticket ticket : table.getRows()) {
			if (ticket.getId().equals(id)) {
				toBeDeleted = ticket;
				System.out.println("FOUND");
				break;
			}
		}
		table.getRows().remove(toBeDeleted);
		serializeToXml(table);
	}

	@Override
	protected Class<TicketTable> getTableClass() {
		return TicketTable.class;
	}

}
