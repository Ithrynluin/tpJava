package thread.exo7;

import java.util.ArrayList;
import java.util.List;

public class TestProducerConsumer {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		new Thread(new Producer(strings, 10)).start();
		new Thread(new Consumer(strings)).start();
		new Thread(new Consumer(strings)).start();
	}
	//Le producteur va produire plus de chaine de caractères que le consommateur ne peut consomme.
	//Ainsi il arrive un moment où le maximun de chaîne est atteint, le producteur attend
	//alors que le consommateur ait consommée une chaîne. 
	
	//Pour consommer plus sans changer l'intervalle du consommateur, on rajoute un consommateur.
}
