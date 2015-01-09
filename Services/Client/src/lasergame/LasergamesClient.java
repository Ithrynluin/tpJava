package lasergame;

import javax.ws.rs.core.MediaType;

import com.iut.detente.lasergame.model.Couleur;
import com.iut.detente.lasergame.model.Joueur;
import com.iut.detente.lasergame.model.Score;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class LasergamesClient {

	public static void main(String[] args) {
		final ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
		final Client client = Client.create(clientConfig);
		
		final Joueur joueur = client.resource(
				"http://localhost:8080/Deuxieme_Web/resource/lasergames/recupererjoueur/1")
				.accept(MediaType.APPLICATION_JSON).get(Joueur.class);
		System.out.println(joueur);
		
		
		final Joueur newJoueur = new Joueur(2, "Le mauvais", Couleur.JAUNE, new Score());
		final Joueur j = client.resource("http://localhost:8080/Deuxieme_Web/resource/lasergames/creerJoueur")
		.accept(MediaType.APPLICATION_JSON)
		.type(MediaType.APPLICATION_JSON_TYPE)
		.post(Joueur.class, newJoueur);
		System.out.println(j);
	}
}
