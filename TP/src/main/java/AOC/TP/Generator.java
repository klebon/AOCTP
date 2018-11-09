package AOC.TP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

//Client/Servant
public class Generator {
	
	public Generator(List<Future> futurList, List<Canal> canalList, int value) {
		super();
		this.futurList = futurList;
		this.canalList = canalList;
		this.value = value;
		this.instance = this;
	}
	
	public static Generator Get() {return instance;}
	
	private List<Future> futurList = new ArrayList<Future>();
	private List<Canal> canalList;
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
		for(Future f : futurList) {
			//f.synchronize();
		}
	}
}
