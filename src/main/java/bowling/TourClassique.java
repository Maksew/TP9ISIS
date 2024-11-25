package bowling;

import java.util.List;

public class TourClassique extends Tour{
	@Override
	public boolean estTermine() {
		return lancers.size() == 2 || (lancers.size() == 1 && lancers.getFirst() == 10); 
	}

	@Override
	public int calculerScore(List<Tour> tours, int index) {
		int score = lancers.stream().mapToInt(Integer::intValue).sum();


		return score;
	}
}
