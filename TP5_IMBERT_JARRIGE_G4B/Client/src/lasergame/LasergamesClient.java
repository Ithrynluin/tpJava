package lasergame;

import javax.ws.rs.core.MediaType;

import com.iut.detente.lasergame.model.Couleur;
import com.iut.detente.lasergame.model.Joueur;
import com.iut.detente.lasergame.model.Score;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class LasergamesClient {

	public static void main(String[] args) {
		final ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
				true);
		final Client client = Client.create(clientConfig);

		Joueur joueur1 = client
				.resource(
						"http://localhost:8080/Deuxieme_Web/resource/lasergames/recupererjoueur/1")
				.accept(MediaType.APPLICATION_JSON).get(Joueur.class);
		System.out.println(joueur1);

		final Joueur newJoueur = new Joueur(2, "Le mauvais", Couleur.JAUNE,
				new Score(2, 104, 45, 10.0));
		final Joueur joueur2 = client
				.resource(
						"http://localhost:8080/Deuxieme_Web/resource/lasergames/creerJoueur")
				.accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.post(Joueur.class, newJoueur);
		System.out.println(joueur2);

		System.out.print("\n\n Recupérer score pour joueur 2 : ");
		WebResource web = client
				.resource("http://localhost:8080/Deuxieme_Web/resource/lasergames/recupererScoreJoueur");
		final int score = web.accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.post(Integer.class, joueur2);
		System.out.println(score);

		System.out.print("\n\n Modifier score joueur 1 : ");
		joueur1.setScore(new Score(1, 2, 53, 100.0));
		client.resource(
				"http://localhost:8080/Deuxieme_Web/resource/lasergames/modifierScoreJoueur")
				.accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON_TYPE).post(joueur1);
		joueur1 = client
				.resource(
						"http://localhost:8080/Deuxieme_Web/resource/lasergames/recupererjoueur/1")
				.accept(MediaType.APPLICATION_JSON).get(Joueur.class);
		System.out.println(joueur1);
	}
}
