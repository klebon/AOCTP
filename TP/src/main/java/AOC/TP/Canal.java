package AOC.TP;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Proxy
public class Canal implements ObsGenAsync{

	private int time;
	private IGenerator generator;
	private ScheduledExecutorService scheduler;
	/**
	 * Displayer used by the canal
	 */
	private ObsGen monitor;
	
	public ObsGen GetAfficheur() { return this.monitor;}
	
	public void SetAfficheur(ObsGen afficheur) {
		this.monitor = afficheur;
	}
	
	public Canal(ScheduledExecutorService scheduler, int time) {
		this.scheduler = scheduler;
		this.time = time;
	}
	
	/***
	 * @param g : Generator (or MementoGenerator) that will be used to get value
	 * 
	 * save g and create new Callable Update with saved monitor
	 */
	public Future<Void> Update(IGenerator g) throws Exception {
		Update mi = new Update(monitor);
		this.generator = g;
		//System.out.println("schedule update");

		return (scheduler.schedule(mi, time, TimeUnit.MILLISECONDS));
		
	}
	
	/***
	 * Create new Callable GetValue with saved generator
	 */
	public Future<Integer> GetValue() throws InterruptedException, ExecutionException {
		GetValue mi = new GetValue(generator);
		//System.out.println("schedule getValue");
		return (scheduler.schedule(mi, time, TimeUnit.MILLISECONDS));
	}

}
