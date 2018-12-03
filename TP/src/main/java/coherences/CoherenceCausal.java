package coherences;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import AOC.TP.IGenerator;
import AOC.TP.ObsGenAsync;

public class CoherenceCausal  implements IAlgoDiffusion {

	private List<ObsGenAsync> canalList;    
	private int nbUpdateRunning = 0;
	
	public CoherenceCausal() {
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
            	c.update(gen);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}

}
