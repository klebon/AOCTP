package AOC.TP;

import java.util.concurrent.Future;

//Proxy
public class Canal implements ObsGenAsync{
	public Future<Integer> update() throws Exception {
		Update mi = new Update();
		return mi.call();
	}
}
