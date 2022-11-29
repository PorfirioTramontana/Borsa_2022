package ImplementazioniPostgresDAO;

import DAO.GiocatoreDAO;
import Database.ConnessioneDatabase;
import Model.Giocatore;
import Model.Societa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class GiocatoreImplementazionePostgresDAO implements GiocatoreDAO {

	private Connection connection;

	public GiocatoreImplementazionePostgresDAO() {
		try {
			connection = ConnessioneDatabase.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void acquistaDB(String nomeGiocatore, Double valoreAzione, int quantita, String societa) {
		try {
			PreparedStatement nuovoAcquistoPS = connection.prepareStatement(
					"INSERT INTO \"Acquisto\" " +
							"(\"NomeSocieta\", \"NomeGiocatore\", \"Quantita\", \"PrezzoAzione\")" +
							"VALUES ('"+societa+"','"+nomeGiocatore+"', "+quantita+", "+valoreAzione+");");
			nuovoAcquistoPS.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
