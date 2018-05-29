package by.edu.grsu.air_company.dao;

import java.util.List;

import by.edu.grsu.air_company.dao.table.BagageTable;
import by.edu.grsu.air_company.entity.Bagage;

public class BagageDao extends AbstractDao<BagageTable, Bagage> {

	public BagageDao(String rootFolderPath) {
		super(rootFolderPath);
	}

	public void saveNew(Bagage entity) {
		entity.setId(getNextId());
		final BagageTable table = deserializeFromXml();
		table.getRows().add(entity);
		serializeToXml(table);
	}

	public void update(Bagage entity) {
		final BagageTable table = deserializeFromXml();
		for (final Bagage bagage : table.getRows()) {
			if (bagage.getId().equals(entity.getId())) {
				bagage.setWeight(entity.getWeight());
				break;
			}
		}
		serializeToXml(table);
	}

	public Bagage get(Integer id) {
		final BagageTable table = deserializeFromXml();
		for (final Bagage bagage : table.getRows()) {
			if (bagage.getId().equals(id)) {
				return bagage;
			}
		}
		return null;
	}

	public List<Bagage> getAll() {
		return deserializeFromXml().getRows();
	}

	public void delete(Integer id) {
		Bagage toBeDeleted = null;
		final BagageTable table = deserializeFromXml();
		for (Bagage bagage : table.getRows()) {
			if (bagage.getId().equals(id)) {
				toBeDeleted = bagage;
				System.out.println("FOUND");
				break;
			}
		}
		table.getRows().remove(toBeDeleted);
		serializeToXml(table);
	}

	@Override
	protected Class<BagageTable> getTableClass() {
		return BagageTable.class;
	}

}
