package AOC.TP;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

//Proxy
public class Canal implements ObsGenAsync{
	
	ScheduledExecutorService scheduler;
	
	public Future<Integer> update() throws Exception {
		Update mi = new Update();
		return mi.call();
	}
	
	public Canal(ScheduledExecutorService scheduler) {
		this.scheduler = scheduler;
	}
}
