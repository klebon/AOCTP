package AOC.TP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

//Client/Servant
public class Generator {
	
	List<Future> futurList = new ArrayList<Future>();
	List<Canal> canalList;
	
	public void Update() throws Exception {
		for(int i = 0; i < canalList.size(); ++i) {
			futurList.set(i,  canalList.get(i).update());
		}
	}
}
