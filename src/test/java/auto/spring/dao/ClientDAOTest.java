package auto.spring.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import auto.spring.modele.Client;

public class ClientDAOTest {

	private EntityManager em;
	private Client client;
	private ClientDAO clientDAO;
	
	@Before
	public void setUp() throws Exception {
		Client client = new Client("bac","die","tok");
		ClientDAO clientDAO = new ClientDAO();
	}
	
	@Test
	public void testSauver() {
		this.clientDAO.sauver(client);
		assertNotEquals(em,null);
	}

	@Test
	public void testGetclientById() {
//		assertnotEquals(clientDAO.getclientById((long)0),null);
	}

	@Test
	public void testGetclients() {
//		fail("Not yet implemented");
	}

}
