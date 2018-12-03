package AOC.TP;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application{


	
	public static void main( String[] args )
    {
    	ScheduledExecutorService service = Executors.newScheduledThreadPool(Integer.MAX_VALUE);

    	canaux = new ArrayList<ObsGenAsync>();
    	int timeToTravel;
    	for(int i = 0; i < nbCanaux; i++) {
    		timeToTravel =  new Random().nextInt(10 - 5) + 5;
    		ObsGenAsync canal = new Canal(service, timeToTravel);
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
		}*/
    }

	@SuppressWarnings("restriction")
	@Override
	public void start(Stage primaryStage) throws Exception {
		 primaryStage.setTitle("AOC Afficheur");
		 Parent root = FXMLLoader.load(getClass().getResource("Vue.fxml"));
	     primaryStage.setScene(new Scene(root, 500, 250));
	     primaryStage.show();
		  
	       		
	}
}
