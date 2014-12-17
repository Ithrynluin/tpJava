package fr.unilim.info.authent;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import fr.unilim.info.authent.exception.CompteInactifException;
import fr.unilim.info.authent.exception.CompteInexistantException;
import fr.unilim.info.authent.exception.MotDePasseIncorrectException;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionTest {

	@Mock
	private IAnnuaire annuaire;
	
	@Mock
	private List<String> sessionMock;
	
	private ServiceAuthentification serviceAuthentification;
	
	@Before 
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		this.serviceAuthentification = new ServiceAuthentification(annuaire){
			@Override
			public List<String> getSessionsEnCours() {
				return sessionMock;
			}
		};
	}
	
	/*
	 * Tests de la méthode connecter
	 */
	@Test
	public void testConnecterWhenBonParametre() throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException{
		
		Mockito.when(annuaire.recupererCompteParIdentifiant("1")).thenReturn(new Compte("1"));
		Mockito.when(annuaire.verifierMotDePasse("1", "azerty")).thenReturn(true);
		
		serviceAuthentification.connecter("1", "azerty");
		
		Mockito.verify(sessionMock).add("1");
	}
	
	@Test(expected = CompteInexistantException.class)
	public void testConnecterWhenCompteInexistant() throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException{
		serviceAuthentification.connecter("1", "azerty");
	}
	
	@Test(expected = CompteInactifException.class)
	public void testConnecterWhenCompteInactif() throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException{
		Compte c = new Compte("1");
		c.setActif(false);
		Mockito.when(annuaire.recupererCompteParIdentifiant("1")).thenReturn(c);
		
		serviceAuthentification.connecter("1", "azerty");
	}
	
	@Test(expected = MotDePasseIncorrectException.class)
	public void testConnecterWhenMdpIncorrect() throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException{
		Mockito.when(annuaire.recupererCompteParIdentifiant("1")).thenReturn(new Compte("1"));
		Mockito.when(annuaire.verifierMotDePasse("1", "azerty")).thenReturn(false);
		
		serviceAuthentification.connecter("1", "azerty");
	}
	
	/*
	 * Tests de la méthode estConnecter
	 */
	@Test
	public void testEstConnecteWhenSessionEnCours(){
		Mockito.when(sessionMock.contains("1")).thenReturn(true);
		
		boolean actual = serviceAuthentification.estConnecte("1");
		
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEstConnecteWhenSessionPasEnCours(){
		Mockito.when(sessionMock.contains("2")).thenReturn(false);
		
		boolean actual = serviceAuthentification.estConnecte("2");
		
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	/*
	 * Tests de la méthode déconnecter
	 */
	@Test
	public void testDeconnecterWhenEstConnecter(){
		Mockito.when(sessionMock.contains("1")).thenReturn(true);
		Mockito.when(sessionMock.remove("1")).thenReturn(true);
		
		boolean actual = serviceAuthentification.deconnecter("1");
		
		boolean expected = true;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDeconnecterWhenPasConnecter(){
		Mockito.when(sessionMock.contains("1")).thenReturn(false);
		
		boolean actual = serviceAuthentification.deconnecter("1");
		
		boolean expected = false;
		
		assertEquals(expected, actual);
	}
	
	@After
	public void tearDown(){
		this.serviceAuthentification = null;
	}
}
