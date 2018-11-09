package AOC.TP;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Update implements Callable<Future<Integer>> {

	private Afficheur aff;
	public Future<Integer> call() throws Exception {
		a.GetValue();
		return null;
	}
	
	public Update(Afficheur a) {
		this.aff = a;
	}

}
