package by.edu.grsu.air_company.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.edu.grsu.air_company.entity.Ticket;

public class TicketDaoTest {

	private static final String XML_PATH = "test";

	private static TicketDao dao;

	@BeforeClass
	public static void createDao() {
		dao = new TicketDao(XML_PATH);
	}
	
	@Test
	public void testSaveNew() {
		System.out.println("Start 'save' test for ticket");
		Ticket ticket = save();
		Assert.assertNotNull(dao.get(ticket.getId()));
	}
	
	@Test
	public void testUpdate() {
		System.out.println("Start 'update' test for ticket");
		Ticket ticket = save();
		ticket.setPrice(1000);
		dao.update(ticket);
		Assert.assertEquals(ticket.getPrice(), dao.get(ticket.getId()).getPrice());
	}
	
	@Test
	public void testGetAll() {
		System.out.println("Start 'getAll' test for ticket");
		final int initialRowsCount = dao.getAll().size();
		save();
		Assert.assertEquals(dao.getAll().size(), initialRowsCount + 1);
	}
	
	@Test
	public void testDelete() {
		System.out.println("Start 'delete' test for ticket");
		Ticket ticket = save();
		dao.delete(ticket.getId());
		Assert.assertNull(dao.get(ticket.getId()));
	}
	
	private static Ticket save() {
		Ticket ticket = new Ticket();
		ticket.setId(1);
		ticket.setFirstAccessStatus(true);
		ticket.setBoughtDate(new Date());
		ticket.setPrice(500);
		dao.saveNew(ticket);
		return ticket;
	}
}
