package auto.spring.modele;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.junit.Before;
import org.junit.Test;

public class CommandeTest {

	private int n_commande;
	private Date date_commande;
	private Date date_livraison;
	private Double frais_port;
	private String destinataire;
	private Double prix_htc;
	private Double prix_ttc;
	private boolean enAttente;
	private Commande nCom;
	
	@Before
	public void setUp() throws Exception {
		n_commande = 0;
		date_commande = new Date();
		date_livraison = new Date();
		frais_port = 20.0;
		destinataire = "kenny";
		prix_htc = 0.5;
		prix_ttc = 0.7;
		enAttente = true;
		nCom = new Commande(n_commande,date_commande, date_livraison, frais_port, destinataire, prix_htc, prix_ttc, enAttente);
	}

	@Test
	public void testGetFrais_port() {
		assertEquals(this.frais_port, this.nCom.getFrais_port());
	}

	@Test
	public void testSetFrais_port() {
		this.nCom.setFrais_port(frais_port);
		assertEquals(this.frais_port, this.nCom.getFrais_port());
	}

	@Test
	public void testGetDestinataire() {
		assertEquals(this.destinataire, this.nCom.getDestinataire());
	}

	@Test
	public void testSetDestinataire() {
		this.nCom.setDestinataire(destinataire);
		assertEquals(this.destinataire, this.nCom.getDestinataire());
	}

	@Test
	public void testGetPrix_htc() {
		assertEquals(this.prix_htc, this.nCom.getPrix_htc());
	}

	@Test
	public void testSetPrix_htc() {
		this.nCom.setPrix_htc(prix_htc);
		assertEquals(this.prix_htc, this.nCom.getPrix_htc());
	}

	@Test
	public void testGetPrix_ttc() {
		assertEquals(this.prix_ttc, this.nCom.getPrix_ttc());
	}

	@Test
	public void testSetPrix_ttc() {
		this.nCom.setPrix_ttc(prix_ttc);
		assertEquals(this.prix_ttc, this.nCom.getPrix_ttc());
	}

	@Test
	public void testAjouter() {
		//todo
	}

	@Test
	public void testIsEnAttente() {
		assertEquals(this.enAttente, this.nCom.isEnAttente());
	}

	@Test
	public void testSetEnAttente() {
		this.nCom.setEnAttente(enAttente);
		assertTrue(this.nCom.isEnAttente());
	}

}
