package coherences;

import java.util.List;

import AOC.TP.IGenerator;
import AOC.TP.ObsGenAsync;

public abstract class Coherence implements IAlgoDiffusion{

	/***
	 * List of Canals
	 */
    protected List<ObsGenAsync> canalList;
	
    /***
     * Setter of canalList
     */
    public abstract void configure(List<ObsGenAsync> canalList);
	
    /***
     * Execute the coherence
     */
	public abstract void execute(IGenerator gen);

}
