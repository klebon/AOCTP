package coherences;

import AOC.TP.IGenerator;

public class MementoGenerator implements IGenerator {

    private int value;
	
	public MementoGenerator(IGenerator gen) {
		setValue(gen.getValue());
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		// TODO Auto-generated method stub
		this.value = value;
	}	

}
