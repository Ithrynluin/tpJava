package lasergame;



import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.iut.detente.lasergame.metier.LaserGameImpl;
import com.iut.detente.lasergame.model.Joueur;
import com.iut.detente.lasergame.model.Partie;
import com.iut.detente.lasergame.model.Score;

@Path("/lasergames")
public class Pojo {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/bonjour")
	public String direBonjour(){
		return "Partie démarrée avec succés : "; 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/recupererjoueur/{joueur}")
	public Joueur recupererJoueur(@PathParam("joueur")Integer idJoueur) {
		Joueur j = LaserGameImpl.getLaserGame().getJoueur(idJoueur);
		return j;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/creerJoueur")
	public Joueur creerJoueur(Joueur joueur) {
		System.out.println("joueur vient : "+joueur);
		LaserGameImpl.getLaserGame().ajouterJoueur(joueur);
		joueur.setPseudo("Le bon");
		return joueur;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/recupererHiScore")
	public int recupererHiScore(){
		return LaserGameImpl.getLaserGame().getHiScore();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/recupererListeJoueurs")
	public List<Joueur> recupererListeJoueur(){
		return LaserGameImpl.getLaserGame().getListeJoueurs();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/recupererNbJoueursActifs")
	public int recupererNbJoueursActifs(){
		return LaserGameImpl.getLaserGame().getNombreParticipantsPartieActive();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/recupererPartieActive")
	public Partie recupererPartieActive(){
		return LaserGameImpl.getLaserGame().getPartieEnCours();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/recupererScoreJoueur")
	public int recupererScoreJoueur(Joueur joueur){
		return LaserGameImpl.getLaserGame().getScorePourJoueur(joueur);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/modifierScoreJoueur")
	public void modifierScoreJoueur(Joueur joueur){
		LaserGameImpl.getLaserGame().setScorePourJoueur(joueur);
	}
	
	@GET
	@Path("/genererPartieAleatoire")
	public void genererPartieJoueur(){
		LaserGameImpl.getLaserGame().genererPartieAleatoire();
	}
	
}
