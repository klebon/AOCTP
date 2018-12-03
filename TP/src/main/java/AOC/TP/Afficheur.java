package AOC.TP;

import javafx.scene.control.Label;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javafx.application.Platform;

//Client/Servant
public class Afficheur implements ObsGen {

	
	public Afficheur(ObsGenAsync c, Label l) {
		super();
		this.c = c;
		this.c.setAfficheur(this);
		this.l=l;
	}
	private Label l;
	private ObsGenAsync c;
	private int value;
	private Future f;
	
	public Future<Integer> GetValue() throws InterruptedException, ExecutionException {
		f = c.GetValue();
		//System.out.println("future of getValue set");
		try {
			setValue((int)(Integer) f.get());
		}
		catch (InterruptedException e){
			e.addSuppressed(e);
			System.out.println("interrupted exception");
		}
		catch(ExecutionException e) {
			e.printStackTrace();
		}
		//System.out.println("Get terminated");
		return f;
	}
	
	private void setValue(int val) {
		value = val;
		Platform.runLater(() ->l.setText(String.valueOf(val)));
		//System.out.println("value set to "+val);
		//display();
	}
	
	private void display() {
		String valueToString = this.value < 10 ? " " : "";
		System.out.println(" ------------------------ \n"
				+ "|                        |\n"
				+ "|                        |\n"
				+ "|                        |\n"
				+ "|           " + value + valueToString + "           |\n"
				+ "|                        |\n"
				+ "|                        |\n"
				+ " ------------------------ "
				);
	}
}
