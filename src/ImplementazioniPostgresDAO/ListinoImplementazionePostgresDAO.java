package ImplementazioniPostgresDAO;

import DAO.ListinoDAO;
import Database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListinoImplementazionePostgresDAO implements ListinoDAO {

	private Connection connection;

	public ListinoImplementazionePostgresDAO(){
		try {
			connection = ConnessioneDatabase.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void leggiListinoDB(String cittaBorsa, ArrayList<String> nomiSocieta, ArrayList<Double> prezziSocieta) {
		PreparedStatement leggiListinoPS;
		try {
			leggiListinoPS = connection.prepareStatement(
					"SELECT * FROM \"Societa\" WHERE \"CittaBorsa\"='"+cittaBorsa+"'");
		ResultSet rs = leggiListinoPS.executeQuery();
		while (rs.next()) {
			nomiSocieta.add(rs.getString("Nome"));
			prezziSocieta.add(rs.getDouble("PrezzoAzione"));
		}
		rs.close();
		connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}

	@Override
	public void addSocietaDB(String text, double parseDouble, String citta) {
		try {
			PreparedStatement addSocietaPS = connection.prepareStatement(
					"INSERT INTO \"Societa\" " +
					"(\"Nome\", \"PrezzoAzione\", \"CittaBorsa\")" +
					"VALUES ('"+text+"', "+parseDouble+", '"+citta+"');");
			addSocietaPS.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
