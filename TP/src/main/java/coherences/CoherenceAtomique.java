package coherences;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import AOC.TP.IGenerator;
import AOC.TP.ObsGenAsync;

public class CoherenceAtomique implements IAlgoDiffusion{

    private List<ObsGenAsync> canalList;
    private List<Future<Void>> futurList;
    
    public CoherenceAtomique(List<ObsGenAsync> canals) {
        this.canalList = canals;
        this.futurList = new ArrayList<Future<Void>>();
    }

    public void configure() {
        // TODO Auto-generated method stub
        
    }

    public void execute(IGenerator gen) {
        // TODO Auto-generated method stub
       // System.out.println("will udpate "+canalList.size()+" canals");
        for(ObsGenAsync c : canalList) {
            //futurList.add();
            try {
				futurList.add(c.update(gen));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        executeFutureList();
    }
    
    private void executeFutureList() {
      //  System.out.println("future get");
    	for(Future f : futurList) {
    		 try {
 				f.get();
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
    	}
    }
}