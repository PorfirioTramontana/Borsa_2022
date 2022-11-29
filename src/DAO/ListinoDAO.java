package DAO;

import java.util.ArrayList;

public interface ListinoDAO {

	public void leggiListinoDB(String cittaBorsa, ArrayList<String> nomiSocieta, ArrayList<Double> prezziSocieta);

	void addSocietaDB(String text, double parseDouble, String citta);
}