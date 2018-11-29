package coherences;

import AOC.TP.IGenerator;

public class MementoGenerator implements IGenerator {

    private int value;
	
	public MementoGenerator(IGenerator gen) {
		setValue(gen.getValue());
	}
	
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public void setValue(int value) {
		// TODO Auto-generated method stub
		this.value = value;
	}

	public void Update() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
