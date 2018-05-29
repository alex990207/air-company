package by.edu.grsu.air_company.dao;

import java.util.List;

import by.edu.grsu.air_company.dao.table.RaceTable;
import by.edu.grsu.air_company.entity.Race;

public class RaceDao extends AbstractDao<RaceTable, Race> {

	public RaceDao(String rootFolderPath) {
		super(rootFolderPath);
	}

	public void saveNew(Race entity) {
		entity.setId(getNextId());
		final RaceTable table = deserializeFromXml();
		table.getRows().add(entity);
		serializeToXml(table);
	}

	public void update(Race entity) {
		final RaceTable table = deserializeFromXml();
		for (final Race race : table.getRows()) {
			if (race.getId().equals(entity.getId())) {
				race.setDate(entity.getDate());
				race.setName(entity.getName());
				serializeToXml(table);
				return;
			}
		}
	}

	public Race get(Integer id) {
		final RaceTable table = deserializeFromXml();
		for (final Race race : table.getRows()) {
			if (race.getId().equals(id)) {
				return race;
			}
		}
		return null;
	}

	public List<Race> getAll() {
		return deserializeFromXml().getRows();
	}

	public void delete(Integer id) {
		Race toBeDeleted = null;
		final RaceTable table = deserializeFromXml();
		for (Race race : table.getRows()) {
			if (race.getId().equals(id)) {
				toBeDeleted = race;
				System.out.println("FOUND");
				break;
			}
		}
		table.getRows().remove(toBeDeleted);
		serializeToXml(table);
	}

	@Override
	protected Class<RaceTable> getTableClass() {
		return RaceTable.class;
	}

}
