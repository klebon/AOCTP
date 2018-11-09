package AOC.TP;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class Update implements Callable<Future<Integer>> {

	private ObsGen aff;
	public Future<Integer> call() throws Exception {
		return aff.GetValue();
	}
	
	public Update(ObsGen monitor) {
		this.aff = monitor;
	}

}
