package fr.unilim.info.authent;

import java.util.ArrayList;
import java.util.List;

import fr.unilim.info.authent.exception.*;

/**
 * Service d'authentification au systeme d'informations
 *
 */
public class ServiceAuthentification {

	/**
	 * Annuaire des utilisateurs du systeme
	 */
	private IAnnuaire annuaire;

	/**
	 * Liste des identifiants des comptes actuellement connect�s au syst�me
	 */
	private List<String> sessionsEnCours;

	/**
	 * Constructeur prenant en argument un IAnnuaire<br>
	 * Initialise la liste des sessions en cours
	 */
	public ServiceAuthentification(IAnnuaire annuaire) {
		this.annuaire = annuaire;
		this.sessionsEnCours = new ArrayList<String>();
	}

	/**
	 * Inscrit un nouvel utilisateur dans le systeme
	 * 
	 * @param id identifiant du nouvel utilisateur
	 * @param motDePasse mot de passe de l'utilisateur
	 * @return true si l'utilisateur a bien ete inscrit, false sinon
	 * @throws IllegalArgumentException si un des parametres en entree (id ou motDePasse) est null
	 * @throws CompteDejaInscritException si l'utilisateur est deja inscrit dans l'annuaire
	 */
	public boolean inscrire(String id, String motDePasse) throws CompteDejaInscritException {
		if(id == null){
			throw new IllegalArgumentException("L'id ne doit pas être null"); 
		}
		if(motDePasse == null){
			throw new IllegalArgumentException("Le mot de passe ne doit pas être null");
		}
		Compte compte = this.annuaire.recupererCompteParIdentifiant(id);
		if(compte != null){
			throw new CompteDejaInscritException("L'utilisateur existe déjà");
		}
		
		return this.annuaire.creerCompte(id, motDePasse);
	}

	/**
	 * Desinscrit un utilisateur du systeme
	 * 
	 * @param id identifiant de l'utilisateur a desinscrire
	 * @return true si l'utilisateur a bien ete desinscrit, false sinon
	 * @throws IllegalArgumentException si le parametre d'entree id est null
	 * @throws CompteInexistantException si l'utilisateur n'est pas inscrit
	 */
	public boolean desinscrire(String id) throws CompteInexistantException {
		if(id == null){
			throw new IllegalArgumentException("L'id ne doit pas être null"); 
		}
		Compte compte = this.annuaire.recupererCompteParIdentifiant(id);
		if(compte == null){
			throw new CompteInexistantException("L'utilisateur n'existe pas");
		}

		return this.annuaire.supprimerCompte(id);
	}

	/**
	 * Connecte un utilisateur
	 * en verifiant la concordance entre son identifiant et de son mot de passe
	 * 
	 * @param id identifiant de l'utilisateur a connecter
	 * @param motDePasse mot de passe de l'utilisateur a connecter
	 * @throws CompteInexistantException si le compte n'existe pas dans le service d'annuaire
	 * @throws CompteInactifException si le compte n'est pas actif
	 * @throws MotDePasseIncorrectException si le mot de passe est incorrect
	 */
	public void connecter(String id, String motDePasse) throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException {
		Compte compte = this.annuaire.recupererCompteParIdentifiant(id);
		if(compte == null){
			throw new CompteInexistantException("L'utilisateur n'existe pas");
		}
		if(!compte.isActif()){
			throw new CompteInactifException("Le compte est inactif");
		}
		if(!annuaire.verifierMotDePasse(id, motDePasse)){
			throw new MotDePasseIncorrectException("Le mot de passe est incorrect");
		}
		
		this.getSessionsEnCours().add(id);
	}

	/**
	 * V�rifie si un utilisateur est actuellement connect� au systeme
	 * @param id identifiant de l'utilisateur
	 * @return true si l'utilisateur est connecte, false sinon
	 */
	public boolean estConnecte(String id) {
		return getSessionsEnCours().contains(id);
	}

	/**
	 * Deconnecte la session d'un utilisateur
	 * @param id identifiant de l'utilisateur
	 * @return true si l'utilisateur a bien ete deconnecte, false sinon
	 */
	public boolean deconnecter(String id) {
		boolean res = false;
		if(estConnecte(id)) {
			res = getSessionsEnCours().remove(id);
		}
		return res;
	}

	/**
	 * Permet de recuperer la liste des sessions en cours
	 * @return la liste des sessions en cours
	 */
	protected List<String> getSessionsEnCours() {
		return sessionsEnCours;
	}

}
