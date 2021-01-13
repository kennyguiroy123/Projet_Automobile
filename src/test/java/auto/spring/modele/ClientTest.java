package auto.spring.modele;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClientTest {

	private Client client;
	private int n_client;
	private String nom_utilisateur;
	private String motdepasse;
	private String token;
	
	@Before
	public void setUp() throws Exception {
		nom_utilisateur ="bac";
		motdepasse="bac";
		token="tok";
		this.client = new Client("bac","bac","tok");
	}

	@Test
	public void testGetNom_utilisateur() {
		assertEquals(this.nom_utilisateur, this.client.getNom_utilisateur());
	}

	@Test
	public void testSetNom_utilisateur() {
		this.client.setNom_utilisateur("bac2");
		assertEquals("bac2", this.client.getNom_utilisateur());
	}

	@Test
	public void testGetMotdepasse() {
		assertEquals(this.motdepasse, this.client.getMotdepasse());
	}

	@Test
	public void testSetMotdepasse() {
		this.client.setNom_utilisateur("bac2");
		assertEquals("bac2", this.client.getNom_utilisateur());
	}

	@Test
	public void testGetToken() {
		assertEquals(this.token, this.client.getToken());
	}

	@Test
	public void testSetToken() {
		this.client.setToken("tok2");
		assertEquals("tok2", this.client.getToken());
	}

}
