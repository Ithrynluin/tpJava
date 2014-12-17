package fr.unilim.info.authent;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import fr.unilim.info.authent.exception.CompteDejaInscritException;
import fr.unilim.info.authent.exception.CompteInexistantException;

@RunWith(MockitoJUnitRunner.class)
public class InscriptionTest {
	
	@Mock
	private IAnnuaire annuaire;
	
	private ServiceAuthentification serviceAuthentification;
	
	@Before 
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		this.serviceAuthentification = new ServiceAuthentification(annuaire);
	}
	
	/*
	 * Tests de la méthode inscrire
	 */
	@Test
	public void testInscrireWhenBonParamètre() throws CompteDejaInscritException{
		Mockito.when(annuaire.creerCompte("1", "azerty")).thenReturn(true);
		
		boolean result = serviceAuthentification.inscrire("1", "azerty");
		
		boolean expected = true;
		
		assertEquals(expected, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInscrireWhenIdNull() throws CompteDejaInscritException{
		serviceAuthentification.inscrire(null, "azerty");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInscrireWhenMotDePasseNull() throws CompteDejaInscritException{
		serviceAuthentification.inscrire("1", null);
	}
	
	@Test(expected = CompteDejaInscritException.class)
	public void testInscrireWhenCompteExistant() throws CompteDejaInscritException{
		Mockito.when(annuaire.recupererCompteParIdentifiant("1")).thenReturn(new Compte("1"));
		serviceAuthentification.inscrire("1", "azerty");
	}
	
	@Test
	public void testDesinscrireWhenBonId() throws CompteInexistantException{
		Mockito.when(annuaire.recupererCompteParIdentifiant("1")).thenReturn(new Compte("1"));
		Mockito.when(annuaire.supprimerCompte("1")).thenReturn(true);
		
		boolean result = serviceAuthentification.desinscrire("1");
		
		boolean expected = true;
		
		assertEquals(expected, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDesinscrireWhenIdNull() throws CompteInexistantException{
		serviceAuthentification.desinscrire(null);
	}
	
	@Test(expected = CompteInexistantException.class)
	public void testDesinscrireWhenCompteInexistant() throws CompteInexistantException{
		serviceAuthentification.desinscrire("2");
	}
	
	@After
	public void tearDown(){
		this.serviceAuthentification = null;
	}
	
}
