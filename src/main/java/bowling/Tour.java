package bowling;

import java.util.ArrayList;
import java.util.List;

public abstract class Tour {
	protected final List<Integer> lancers = new ArrayList<>();

	public void ajouterLancer(int quillesAbattues) {
		lancers.add(quillesAbattues);
	}

	public abstract boolean estTermine();
	public abstract int calculerScore(List<Tour> tours, int index);

	public int prochainLancer() {
		return lancers.size() + 1;
	}
}