package by.edu.grsu.air_company.dao;

import java.util.List;

import by.edu.grsu.air_company.dao.table.UserTable;
import by.edu.grsu.air_company.entity.User;

public class UserDao extends AbstractDao<UserTable, User> {

	public UserDao(String rootFolderPath) {
		super(rootFolderPath);
	}

	public void saveNew(User entity) {
		entity.setId(getNextId());
		final UserTable table = deserializeFromXml();
		table.getRows().add(entity);
		serializeToXml(table);
	}

	public void update(User entity) {
		final UserTable table = deserializeFromXml();
		for (final User user : table.getRows()) {
			if (user.getId().equals(entity.getId())) {
				user.setName(entity.getName());
				user.setPassword(entity.getPassword());
				user.setPatronymic(entity.getPatronymic());
				user.setPhoneNumber(entity.getPhoneNumber());
				user.setSurname(entity.getSurname());
				user.setTickets(entity.getTickets());
				user.setUserStatus(entity.getUserStatus());
				serializeToXml(table);
				return;
			}
		}
	}

	public User get(Integer id) {
		final UserTable table = deserializeFromXml();
		for (final User user : table.getRows()) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	public List<User> getAll() {
		return deserializeFromXml().getRows();
	}

	public void delete(Integer id) {
		User toBeDeleted = null;
		final UserTable table = deserializeFromXml();
		for (User user : table.getRows()) {
			if (user.getId().equals(id)) {
				toBeDeleted = user;
				System.out.println("FOUND");
				break;
			}
		}
		table.getRows().remove(toBeDeleted);
		serializeToXml(table);
	}

	@Override
	protected Class<UserTable> getTableClass() {
		return UserTable.class;
	}

}
