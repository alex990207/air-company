package by.edu.grsu.air_company.dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.edu.grsu.air_company.entity.Race;

public class RaceDaoTest {

	private static final String XML_PATH = "test";

	private static RaceDao dao;

	@BeforeClass
	public static void createDao() {
		dao = new RaceDao(XML_PATH);
	}

	@Test
	public void testSaveNew() {
		System.out.println("Start 'save' test for race");
		Race race = save();
		Assert.assertNotNull(dao.get(race.getId()));
	}

	@Test
	public void testUpdate() {
		System.out.println("Start 'update' test for race");
		Race race = save();
		race.setName("Grodno-Krakov");
		dao.update(race);
		Assert.assertEquals(race.getName(), dao.get(race.getId()).getName());
	}

	@Test
	public void testGetAll() {
		System.out.println("Start 'getAll' test for race");
		final int initialRowsCount = dao.getAll().size();
		save();
		Assert.assertEquals(dao.getAll().size(), initialRowsCount + 1);
	}

	@Test
	public void testDelete() {
		System.out.println("Start 'delete' test for race");
		Race race = save();
		dao.delete(race.getId());
		Assert.assertNull(dao.get(race.getId()));
	}

	private static Race save() {
		Race race = new Race();
		race.setId(1);
		race.setName("Grodno-Minsk");
		dao.saveNew(race);
		return race;
	}
}
