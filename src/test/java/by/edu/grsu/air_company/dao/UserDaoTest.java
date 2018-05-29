package by.edu.grsu.air_company.dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.edu.grsu.air_company.entity.User;

public class UserDaoTest {

	private static final String XML_PATH = "test";

	private static UserDao dao;

	@BeforeClass
	public static void createDao() {
		dao = new UserDao(XML_PATH);
	}

	@Test
	public void testSaveNew() {
		System.out.println("Start 'save' test for user");
		User user = save();
		Assert.assertNotNull(dao.get(user.getId()));
	}

	@Test
	public void testUpdate() {
		System.out.println("Start 'update' test for user");
		User user = save();
		user.setPassword("pchelki-ju-ju-ju");
		dao.update(user);
		Assert.assertEquals(user.getPassword(), dao.get(user.getId()).getPassword());
	}

	@Test
	public void testGetAll() {
		System.out.println("Start 'getAll' test for user");
		final int initialRowsCount = dao.getAll().size();
		save();
		Assert.assertEquals(dao.getAll().size(), initialRowsCount + 1);
	}

	@Test
	public void testDelete() {
		System.out.println("Start 'delete' test for user");
		User user = save();
		dao.delete(user.getId());
		Assert.assertNull(dao.get(user.getId()));
	}

	private static User save() {
		User user = new User();
		user.setId(1);
		user.setName("Alex");
		user.setSurname("Bilevsky");
		user.setPatronymic("Batkovich");
		user.setPhoneNumber("375292689578");
		user.setPassword("poitrulit");
		dao.saveNew(user);
		return user;
	}
}
