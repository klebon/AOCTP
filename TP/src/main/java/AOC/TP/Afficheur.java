package AOC.TP;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

//Client/Servant
public class Afficheur implements ObsGen {

	
	public Afficheur(Canal c) {
		super();
		this.c = c;
	}

	private Canal c;
	private int value;
	private Future f;
	
	public void GetValue() throws InterruptedException, ExecutionException {
		f = c.GetValue();
	}
}
