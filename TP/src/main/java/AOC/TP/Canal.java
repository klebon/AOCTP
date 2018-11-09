package AOC.TP;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Proxy
public class Canal implements ObsGenAsync{
	
	ScheduledExecutorService scheduler;
	private ObsGen monitor;
	
	public void setAfficheur(ObsGen afficheur) {
		this.monitor = afficheur;
	}
		
	public Future<Integer> update() throws Exception {
		Update mi = new Update(monitor);
		
		return (scheduler.schedule(mi, 500, TimeUnit.MILLISECONDS)).get();
		
	}
	
	public Canal(ScheduledExecutorService scheduler) {
		this.scheduler = scheduler;
	}
	
	public Future<Integer> GetValue() throws InterruptedException, ExecutionException {
		GetValue mi = new GetValue();
		return (scheduler.schedule(mi, 500, TimeUnit.MILLISECONDS));
	}
}
