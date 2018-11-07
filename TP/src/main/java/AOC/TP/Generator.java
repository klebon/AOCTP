package AOC.TP;

import java.util.concurrent.Future;

//Client/Servant
public class Generator {
	
	Future f;
	
	public void Update(Canal c) {
		f = c.update();
	}
}
