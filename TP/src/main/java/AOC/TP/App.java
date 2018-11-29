package AOC.TP;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App {

	private static int nbCanaux = 4;
	private static List<ObsGenAsync> canaux;
	
	public static void main( String[] args )
    {
    	ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
    	canaux = new ArrayList<ObsGenAsync>();
    	for(int i = 0; i < nbCanaux; i++) {
    		ObsGenAsync canal = new Canal(service, 500);
    		ObsGen aff = new Afficheur(canal);
    		canaux.add(canal);
    	}
    	//System.out.println("created "+nbCanaux+" canaux");
		Generator gen = new Generator(canaux);
    	try {
    		gen.go();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
