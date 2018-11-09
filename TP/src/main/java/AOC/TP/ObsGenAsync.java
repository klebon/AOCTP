package AOC.TP;

import java.util.concurrent.Future;

public interface ObsGenAsync extends ObsGen{
	public Future<Integer> update() throws Exception;

	public void setAfficheur(ObsGen afficheur);
	
}
