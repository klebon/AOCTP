package coherences;

import java.util.List;

import AOC.TP.IGenerator;
import AOC.TP.ObsGenAsync;

public interface IAlgoDiffusion {

	void configure(List<ObsGenAsync> canalList);
	
	void execute(IGenerator gen);
}
