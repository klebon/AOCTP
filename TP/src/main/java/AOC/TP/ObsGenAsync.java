package AOC.TP;

public interface ObsGenAsync extends ObsGen{
	public Future<Integer> update();
}
