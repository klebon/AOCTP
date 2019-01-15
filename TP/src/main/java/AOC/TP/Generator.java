package AOC.TP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import coherences.CoherenceAtomique;
import coherences.CoherenceCausal;
import coherences.CoherenceSequentielle;
import coherences.IAlgoDiffusion;

//Client/Servant
public class Generator implements IGenerator {
    
    private static int max = 100, min = 1;
    private List<ObsGenAsync> canalList;
    
    private int value;
    public void setValue(int value) {
        this.value=value;
    }
    private boolean increment;
    public int getValue() {return this.value;}
    
    private IAlgoDiffusion coherence;
    
    /***
     * Create a new Generator by passing list of Canals,
     * @param canalList
     * @param increment : if false, generator will generate number randomly, otherwise generation will be in chronological order
     */
    public Generator(List<ObsGenAsync> canalList, boolean increment) {
        super();
        this.increment = increment;
        this.canalList = canalList;
        if(increment) {
        	this.value = 0;
        }else {
            this.value = new Random().nextInt(max - min + 1) + min;
        }
        //this.coherence = new CoherenceAtomique(canalList);
        //this.coherence = new CoherenceSequentielle();
        this.coherence = new CoherenceCausal();
        coherence.configure(canalList);
    }
    
    /***
     *     
     * @param s : name of the coherence to choose
     */
    public void setCoherence(String s) {
    	if(s.equals("Seq")) {
    		this.coherence=new CoherenceSequentielle();
    		this.coherence.configure(canalList);
    	}
    	else if (s.equals("Caus")){
    		this.coherence=new CoherenceCausal();
    		this.coherence.configure(canalList);
    	}
    	else {
     		this.coherence=new CoherenceAtomique();
    		this.coherence.configure(canalList);
    	}
    }
    
    /***
     * Loop : change actual value of generator and call coherence
     */
    public void go() {
    	while(true) {
    		if(increment) {
    			this.value++;
    		}else {
    			this.value = new Random().nextInt(max - min + 1) + min;
    		}
    		try {
				this.Update();
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt((1500 - 750) + 750));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    /***
     * Run the chosen coherence
     */
    public void Update() throws Exception {
        coherence.execute(this);
    }
}