package bowling;

import java.util.List;

public class DernierTour extends Tour{
	@Override
	public boolean estTermine() {
		if (lancers.size() == 2 && lancers.get(0) + lancers.get(1) < 10) return true; // Pas de spare/strike
		return lancers.size() == 3; // Maximum 3 lancers
	}

	@Override
	public int calculerScore(List<Tour> tours, int index) {
		return lancers.stream().mapToInt(Integer::intValue).sum();
	}
}
