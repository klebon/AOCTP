package AOC.TP;

import javafx.scene.control.Label;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javafx.application.Platform;

//Client/Servant
public class Afficheur implements ObsGen {

	public Afficheur(ObsGenAsync c, Label l) {
		super();
		this.canal = c;
		this.canal.SetAfficheur(this);
		this.label=l;
	}
	
	private Label label;
	private ObsGenAsync canal;
	private int value;
	private Future future;
	
	/***
	 * Get the future from the saved Canal and try getting the value
	 */
	public Future<Integer> GetValue() throws InterruptedException, ExecutionException {
		future = canal.GetValue();

		try {
			setValue((int)(Integer) future.get());
		}
		catch (InterruptedException e){
			e.addSuppressed(e);
			System.out.println("interrupted exception");
		}
		catch(ExecutionException e) {
			e.printStackTrace();
		}
		return future;
	}
	
	/**
	 * modify actual value and apply new value in GUI
	 * @param val : new value to display
	 */
	private void setValue(int val) {
		value = val;
		Platform.runLater(() -> label.setText(String.valueOf(val)));
		//System.out.println("value set to "+val);
		//display();
	}
	
	/***
	 * Display value in the console
	 */
	private void display() {
		String valueToString = this.value < 10 ? " " : "";
		System.out.println(" ------------------------ \n"
				+ "|                        |\n"
				+ "|                        |\n"
				+ "|           " + value + valueToString + "           |\n"
				+ "|                        |\n"
				+ "|                        |\n"
				+ " ------------------------ "
				);
	}
}
