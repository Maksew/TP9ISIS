package bowling;

import java.util.*;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancers successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class PartieMonoJoueur {
	private final List<Tour> tours = new ArrayList<>();
	private boolean partieTerminee = false;


	/**
	 * Constructeur
	 */
	public PartieMonoJoueur() {
		tours.add(new TourClassique());
	}


	/**
	 * Cette méthode doit être appelée à chaque lancer de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de ce lancer
	 * @throws IllegalStateException si la partie est terminée
	 * @return vrai si le joueur doit lancer à nouveau pour continuer son tour, faux sinon	
	 */
	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (partieTerminee) {
			throw new IllegalStateException("La partie est déjà terminée.");
		}

		Tour tourCourant = tours.getLast();
		tourCourant.ajouterLancer(nombreDeQuillesAbattues);

		if (tourCourant.estTermine()) {
			if (tours.size() < 10) {
				tours.add(tours.size() == 9 ? new DernierTour() : new TourClassique());
			} else {
				partieTerminee = true;
			}
		}

		return !partieTerminee;
	}


	/**
	 * Cette méthode donne le score du joueur.
	 * Si la partie n'est pas terminée, on considère que les lancers restants
	 * abattent 0 quille.
	 * @return Le score du joueur
	 */
	public int score() {
		int score = 0;
		for (int i = 0; i < tours.size(); i++) {
			score += tours.get(i).calculerScore(tours, i);
		}
		return score;
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		return partieTerminee;
	}



	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		if (partieTerminee) {
			return 0; 
		}
		return tours.size(); 
	}
	
	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 *         est fini
	 */
	public int numeroProchainLancer() {
		if (partieTerminee) {
			return 0; 
		}
		// Déléguer au tour actuel
		Tour tourCourant = tours.getLast();
		return tourCourant.prochainLancer();
	}
}
