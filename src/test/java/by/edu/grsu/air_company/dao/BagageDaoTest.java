package by.edu.grsu.air_company.dao;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.edu.grsu.air_company.entity.Bagage;

public class BagageDaoTest {

	private static final String XML_PATH = "test";

	private static BagageDao dao;

	@BeforeClass
	public static void createDao() {
		dao = new BagageDao(XML_PATH);
	}
	
	@Test
	public void testSaveNew() {
		System.out.println("Start 'save' test for bagage");
		Bagage bagage = save();
		Assert.assertNotNull(dao.get(bagage.getId()));
	}
	
	@Test
	public void testUpdate() {
		System.out.println("Start 'update' test for bagage");
		Bagage bagage = save();
		bagage.setWeight(666.666);
		dao.update(bagage);
		Assert.assertEquals(bagage.getWeight(), dao.get(bagage.getId()).getWeight());
	}
	
	@Test
	public void testGetAll() {
		System.out.println("Start 'getAll' test for bagage");
		final int initialRowsCount = dao.getAll().size();
		save();
		Assert.assertEquals(dao.getAll().size(), initialRowsCount + 1);
	}
	
	@Test
	public void testDelete() {
		System.out.println("Start 'delete' test for bagage");
		Bagage bagage = save();
		dao.delete(bagage.getId());
		Assert.assertNull(dao.get(bagage.getId()));
	}
	
	private static Bagage save() {
		Bagage bagage = new Bagage();
		bagage.setId(1);
		bagage.setWeight(50.5);
		dao.saveNew(bagage);
		return bagage;
	}
}
