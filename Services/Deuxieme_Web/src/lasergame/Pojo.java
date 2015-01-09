package lasergame;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.iut.detente.lasergame.metier.LaserGameImpl;
import com.iut.detente.lasergame.model.Joueur;

@Path("/lasergames")
public class Pojo {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/bonjour")
	public String direBonjour(){
		return "Partie démarrée avec succès : "; 
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
	
}
