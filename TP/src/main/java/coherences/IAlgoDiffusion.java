package coherences;

import AOC.TP.IGenerator;

public interface IAlgoDiffusion {

	void configure();
	
	void execute(IGenerator gen);
}
