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
    	launch(args);
    	
    }

	@SuppressWarnings("restriction")
	@Override
	public void start(Stage primaryStage) throws Exception {
		 primaryStage.setTitle("AOC Afficheur");
		 Parent root = FXMLLoader.load(getClass().getResource("Vue.fxml"));
	     primaryStage.setScene(new Scene(root, 500, 250));
	     primaryStage.show();
	     primaryStage.setOnCloseRequest(e -> System.exit(0));
	}
}
