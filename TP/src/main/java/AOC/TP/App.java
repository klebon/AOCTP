package AOC.TP;

import java.util.concurrent.ScheduledExecutorService;
import java.util.ArrayList;
import java.util.List;


public class App {

	private int nbCanaux = 4;
	private List<Canal> canaux;
	
	public static void main( String[] args )
    {
    	ScheduledExecutorService service = new ScheduledExecutorService();
    	canaux = new ArrayList<Canal>();
    	for(int i = 0; i < nbCanaux; i++) {
    		Canal canal = new Canal(service);
    		Afficheur aff = new Afficheur(canal);
    		canaux.add(canal);
    	}
		Generator gen = new Generator(canaux);
    	gen.Update();
    }
}
