package AOC.TP;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Proxy
public class Canal implements ObsGenAsync{
	
	ScheduledExecutorService scheduler;
		
	public Future<Integer> update() throws Exception {
		Update mi = new Update();
		
		return (Future)(scheduler.schedule(mi, 500, TimeUnit.MILLISECONDS));
		
	}
	
	public Canal(ScheduledExecutorService scheduler) {
		this.scheduler = scheduler;
	}
}
