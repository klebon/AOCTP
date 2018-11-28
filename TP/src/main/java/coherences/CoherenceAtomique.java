package coherences;

import java.util.List;

import AOC.TP.ObsGenAsync;

public class CoherenceAtomique implements IAlgoDiffusion{

	private List<ObsGenAsync> canals;
	
	public CoherenceAtomique(List<ObsGenAsync> canals) {
		this.canals = canals;
	}
}
