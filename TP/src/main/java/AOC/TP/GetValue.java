package AOC.TP;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class GetValue implements Callable<Integer> {

	public Integer call() throws Exception {
		
		Integer value = (Integer) Generator.Get().getValue();		
		return value;
	}

}
