package AOC.TP;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Proxy
public class Canal implements ObsGenAsync{
	
	Generator generator;
	ScheduledExecutorService scheduler;
	private ObsGen monitor;
	private int time;
	
	public void setAfficheur(ObsGen afficheur) {
	//	System.out.println("afficher set ot the canal");
		this.monitor = afficheur;
	}
		
	public Future<Void> update(Generator g) throws Exception {
		Update mi = new Update(monitor);
		this.generator = g;
		//System.out.println("schedule update");

		return (scheduler.schedule(mi, 500, TimeUnit.MILLISECONDS));
		
	}
	
	public Canal(ScheduledExecutorService scheduler, int time) {
		this.scheduler = scheduler;
		this.time = time;
	}
	
	public Future<Integer> GetValue() throws InterruptedException, ExecutionException {
		GetValue mi = new GetValue(generator);
		//System.out.println("schedule getValue");
		return (scheduler.schedule(mi, time, TimeUnit.MILLISECONDS));
	}
}
