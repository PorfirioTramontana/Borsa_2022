package ImplementazioniPostgresDAO;

import DAO.SocietaDAO;
import Database.ConnessioneDatabase;
import Model.Societa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SocietaImplementazionePostgresDAO implements SocietaDAO {
	
	private Connection connection;
	
	public SocietaImplementazionePostgresDAO() {
		try {
			connection=ConnessioneDatabase.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void updatePrezzo(String nomeSocieta, float nuovoPrezzo) {
		try {
			//UPDATE "Borsa"."Societa" SET "PrezzoAzione" = 21 WHERE "Nome" = 'google';
			PreparedStatement updatePrezzoPS = connection.prepareStatement(
					"UPDATE \"Societa\" " +
					"SET \"PrezzoAzione\" = "+nuovoPrezzo+ 
					"WHERE \"Nome\" = '"+nomeSocieta+"' ;");
			
			updatePrezzoPS.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
