package coherences;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import AOC.TP.IGenerator;
import AOC.TP.ObsGenAsync;

public class CoherenceCausal extends Coherence {
  
	//private int nbUpdateRunning;
	
	public CoherenceCausal() {
		//nbUpdateRunning = 0;
	}
	
	public void configure(List<ObsGenAsync> canalList) {
		// TODO Auto-generated method stub
		  this.canalList = canalList;
	}

	public void execute(IGenerator gen) {
		// TODO Auto-generated method stub
		for(ObsGenAsync c : canalList) {
            //futurList.add();
            try {
            	c.Update(gen);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}

}
