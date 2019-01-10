package AOC.TP;

public interface IGenerator {

	public int getValue();
	public void setValue(int value);
	public void go();
	
	public void Update() throws Exception;
}
