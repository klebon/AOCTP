package AOC.TP;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public interface ObsGen {
	public Future<Integer> GetValue() throws InterruptedException, ExecutionException;
}
