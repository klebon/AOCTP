package AOC.TP;

import java.util.concurrent.Future;

public interface ObsGenAsync extends ObsGen{
	
	
	public Future<Void> Update(IGenerator g) throws Exception;

	public void SetAfficheur(ObsGen afficheur);
	public ObsGen GetAfficheur();
}
