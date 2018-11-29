package AOC.TP;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Update implements Callable<Void> {

	private ObsGen aff;
	public Void call() throws Exception {
	//	System.out.println("afficheur called");
		aff.GetValue();
		return null;
	}
	
	public Update(ObsGen monitor) {
		this.aff = monitor;
	//	System.out.println("afficheur set");
	}

}
