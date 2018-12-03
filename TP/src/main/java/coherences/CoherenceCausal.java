package coherences;

import java.util.List;
import java.util.concurrent.Future;

import AOC.TP.IGenerator;
import AOC.TP.ObsGenAsync;

public class CoherenceCausal  implements IAlgoDiffusion {

	private List<ObsGenAsync> canalList;
    private List<Future<Void>> futurList;
    

	public CoherenceCausal(List<Future<Void>> futurList) {
		this.futurList = futurList;
	}
	
	public void configure(List<ObsGenAsync> canalList) {
		// TODO Auto-generated method stub
		  this.canalList = canalList;
	}

	public void execute(IGenerator gen) {
		// TODO Auto-generated method stub
		
	}

}
