package AOC.TP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

import coherences.CoherenceAtomique;
import coherences.CoherenceCausal;
import coherences.CoherenceSequentielle;
import coherences.IAlgoDiffusion;

//Client/Servant
public class Generator implements IGenerator {
    
    private static int max = 100, min = 1;
    
    public Generator(List<ObsGenAsync> canalList) {
        super();
        this.canalList = canalList;
        this.futurList = new ArrayList<Future<Void>>();
        this.value = new Random().nextInt(max - min + 1) + min;
        this.instance = this;
        //this.coherence = new CoherenceAtomique(canalList);
        //this.coherence = new CoherenceSequentielle();
        this.coherence = new CoherenceCausal();
        coherence.configure(canalList);
    }
    
    //public static Generator Get() {return instance;}
    
    private List<Future<Void>> futurList = new ArrayList<Future<Void>>();
    private List<ObsGenAsync> canalList;
    private int value;
    private static Generator instance;
    
    private IAlgoDiffusion coherence;
    
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
    
    public Generator(int value) {
        this.value=value;
        }
    public void setValue(int value) {
        this.value=value;
    }
    public void go() {
    	while(true) {
    		this.value = new Random().nextInt(max - min + 1) + min;
    		try {
				this.Update();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    }
    
    public int getValue() {return this.value;}
    
    public void Update() throws Exception {
        coherence.execute(this);
    }
}