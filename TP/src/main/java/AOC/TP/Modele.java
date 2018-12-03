package AOC.TP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Modele {
     private boolean go;
    @FXML
    private Label Afficheur1;
    @FXML
    private Label Afficheur2;
    @FXML
    private RadioButton AtomiStrat;
    @FXML
    private RadioButton SeqStrat;
    @FXML 
    private RadioButton CausStrat;
    @FXML
    private Label Afficheur3;
    @FXML
    private Label Afficheur4;
    @FXML
    private Button Go;
    
    
	private  int nbCanaux = 4;
	private  List<ObsGenAsync> canaux;
	private  List<ObsGen> afficheur;
	private ScheduledExecutorService service;
    
    Generator generator;
    @FXML
    public void initialize() {
    	go=true;
    	Go.setDisable(false);
    	service = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
    	canaux = new ArrayList<ObsGenAsync>();
    	afficheur = new ArrayList<ObsGen>();
    	int timeToTravel;
    	for(int i = 0; i < nbCanaux; i++) {
    		timeToTravel =  new Random().nextInt(3 - 1) + 1;
    		ObsGenAsync canal = new Canal(service, timeToTravel);
    		canaux.add(canal);
    	}
    	ObsGen aff1 = new Afficheur(canaux.get(0),Afficheur1);
    	ObsGen aff2 = new Afficheur(canaux.get(1),Afficheur2);
    	ObsGen aff3 = new Afficheur(canaux.get(2),Afficheur3);
    	ObsGen aff4 = new Afficheur(canaux.get(3),Afficheur4);
    	afficheur.add(aff1);
    	afficheur.add(aff2);
    	afficheur.add(aff3);
    	afficheur.add(aff4);
		Generator gen = new Generator(canaux);
		generator = gen;
		AtomiStrat.setSelected(true);
		SeqStrat.setSelected(false);
		CausStrat.setSelected(false);
    }
    
    @FXML
    private void start(){
        service.scheduleAtFixedRate(() -> generator.go(), 0, 100, TimeUnit.MILLISECONDS);
        Go.setDisable(true);
        go = !go;
    }
    @FXML
    private void GoToAtom() {
    	generator.setCoherence("atomique");
    	AtomiStrat.setSelected(true);
    	System.out.println("JE SUIS PASSÉ ICI");
    	SeqStrat.setSelected(false);
    	CausStrat.setSelected(false);
    }
    @FXML
    private void GoToSeq() {
    	generator.setCoherence("Seq");
    	SeqStrat.setSelected(true);
    	AtomiStrat.setSelected(false);
    	CausStrat.setSelected(false);
    }
    @FXML
    private void GoToCaus() {
    	generator.setCoherence("Caus");
    	SeqStrat.setSelected(false);
    	AtomiStrat.setSelected(false);
    	CausStrat.setSelected(true);
    }
}



