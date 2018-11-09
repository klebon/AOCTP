package AOC.TP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

//Client/Servant
public class Generator {
	
	private static int max = 100, min = 1;
	
	public Generator(List<ObsGenAsync> canalList) {
		super();
		this.canalList = canalList;
		this.futurList = new ArrayList<Future<Integer>>();
		this.value = new Random().nextInt(max - min + 1) + min;
		this.instance = this;
	}
	
	public static Generator Get() {return instance;}
	
	private List<Future<Integer>> futurList = new ArrayList<Future<Integer>>();
	private List<ObsGenAsync> canalList;
	private int value;
	private static Generator instance;
	
	public Generator(int value) {
		this.value=value;
		}
	public void setValue(int value) {
		this.value=value;
	}
	
	public int getValue() {return this.value;}
	
	public void Update() throws Exception {
		for(Canal c : canalList) {
			futurList.add(c.update());
		}
	}
}
