package DAO;

import Model.Giocatore;
import Model.Societa;

import java.time.LocalDate;

public interface GiocatoreDAO {

	/**
	 * Acquista.
	 *
	 * @param i the i
	 * @param now the now
	 * @param prezzo the prezzo
	 * @param societa the societa
	 */
    void acquistaDB(String nome, Double valoreAzione, int quantita, String societa);
}