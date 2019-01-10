package coherences;

import java.util.List;

import AOC.TP.IGenerator;
import AOC.TP.ObsGenAsync;

public abstract class Coherence implements IAlgoDiffusion{

    protected List<ObsGenAsync> canalList;
	
    public abstract void configure(List<ObsGenAsync> canalList);
	
	public abstract void execute(IGenerator gen);

}
