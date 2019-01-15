package AOC.TP;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface ObsGen {
	
	/***
	 * Call to obtain the future containing the next value to display
	 * @return Future that (will) contains the next value to display
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public Future<Integer> GetValue() throws InterruptedException, ExecutionException;
}
