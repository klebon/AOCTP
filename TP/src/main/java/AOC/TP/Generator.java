package AOC.TP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

//Client/Servant
public class Generator {
	
	private List<Future> futurList = new ArrayList<Future>();
	private List<Canal> canalList;
	private int value;
	
	public Generator(int value) {
		this.value=value;
		}
	public void setValue(int value) {
		this.value=value;
	}
	public void Update() throws Exception {
		for(int i = 0; i < canalList.size(); ++i) {
			futurList.set(i,  canalList.get(i).update());
		}
	}
}
