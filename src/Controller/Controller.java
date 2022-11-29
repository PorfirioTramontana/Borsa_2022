package Controller;

import DAO.GiocatoreDAO;
import DAO.ListinoDAO;
import ImplementazioniPostgresDAO.GiocatoreImplementazionePostgresDAO;
import ImplementazioniPostgresDAO.ListinoImplementazionePostgresDAO;
import Model.*;

import java.util.ArrayList;

/**
 * The type Controller.
 */
public class Controller {

    private Borsa borsa;
    private Giocatore giocatore;
    private Listino listino;

    /**
     * Instantiates a new Controller.
     */
    public Controller() {

    }

    /**
     * Sets nome giocatore.
     *
     * @param text the text
     */
    public void setNomeGiocatore(String text) {
        giocatore=new Giocatore(text);
    }

    /**
     * Sets citta borsa.
     *
     * @param text the text
     */
    public void setCittaBorsa(String text) {
        borsa=new Borsa(new Listino()); //crea borsa in memoria
        borsa.setCitta(text);
        listino=borsa.getListino();
        ListinoDAO l=new ListinoImplementazionePostgresDAO();
        //legge listino da DB e lo scrive in memoria
        ArrayList<String> nomiSocieta=new ArrayList<String>();
        ArrayList<Double> prezziSocieta=new ArrayList<Double>();
        l.leggiListinoDB(borsa.getCitta(),nomiSocieta,prezziSocieta);  //legge listino dal DB
        for(int i=0;i<nomiSocieta.size();i++) {
            Societa s=new Societa(nomiSocieta.get(i),prezziSocieta.get(i));
            listino.addSocieta(s);
        }
    }

    /**
     * Aggiungi societa listino.
     *
     * @param text        the text
     * @param parseDouble the parse double
     */
    public void aggiungiSocietaListino(String text, double parseDouble) {
        listino.aggiungiSocieta(text, parseDouble); //in memoria
        ListinoDAO l=new ListinoImplementazionePostgresDAO();
        l.addSocietaDB(text, parseDouble,borsa.getCitta()); //in DB
    }

    /**
     * Gets nomi societa da listino.
     *
     * @return the nomi societa da listino
     */
    public ArrayList getNomiSocietaDaListino() {
        return listino.getNomiSocieta();
    }

    /**
     * Gets valori azioneda listino.
     *
     * @return the valori azioneda listino
     */
    public ArrayList getValoriAzionedaListino() {
        return listino.getValoriAzione();
    }

    /**
     * Modifica valore azione.
     *
     * @param text        the text
     * @param parseDouble the parse double
     */
    public void modificaValoreAzione(String text, double parseDouble) {
        Societa s=listino.getSocietaPerNome(text);
        if (s!=null)
            s.setValoreAzione(parseDouble);
    }

    /**
     * Gets valore azione.
     *
     * @param text the text
     * @return the valore azione
     */
    public Double getValoreAzione(String text) {
        return listino.getValoreAzione(text);
    }

    /**
     * Acquista azione.
     *
     * @param societa      the societa
     * @param valoreAzione the valore azione
     * @param quantita     the quantita
     */
    public void acquistaAzione(String societa, Double valoreAzione, int quantita) {
        giocatore.acquistaAzione(societa, valoreAzione, listino, quantita); //in memoria
        GiocatoreDAO gDAO=new GiocatoreImplementazionePostgresDAO();
        gDAO.acquistaDB(giocatore.getNome(), valoreAzione, quantita, societa); //su DB

    }

    /**
     * Gets nomi societa acquisti.
     *
     * @return the nomi societa acquisti
     */
    public ArrayList getNomiSocietaAcquisti() {
        ArrayList<Acquisto> a=giocatore.getAcquisti();
        ArrayList<String> nomiSocieta=new ArrayList<String>();
        for (Acquisto acquisto : a) {
            nomiSocieta.add(acquisto.getAzione().getSocieta().getNome());
        }
        return nomiSocieta;
    }

    /**
     * Gets valori azione acquisti.
     *
     * @return the valori azione acquisti
     */
    public ArrayList getValoriAzioneAcquisti() {
        ArrayList<Acquisto> a=giocatore.getAcquisti();
        ArrayList<Double> valoriAzione=new ArrayList<Double>();
        for (Acquisto acquisto : a) {
            valoriAzione.add((double) acquisto.getAzione().getPrezzo());
        }
        return valoriAzione;
    }

    /**
     * Gets quantita acquisti.
     *
     * @return the quantita acquisti
     */
    public ArrayList getQuantitaAcquisti() {
        ArrayList<Acquisto> a=giocatore.getAcquisti();
        ArrayList<Integer> quantita=new ArrayList<Integer>();
        for (Acquisto acquisto : a) {
            quantita.add((int) acquisto.getQuantita());
        }
        return quantita;
    }

    /**
     * Gets disponibilita.
     *
     * @return the disponibilita
     */
    public String getDisponibilita() {
        return String.valueOf(giocatore.getLiquidita());
    }

    /**
     * Gets bilancio.
     *
     * @return the bilancio
     */
    public String getBilancio() {
        return String.valueOf(giocatore.calcolaCapitale());
    }

    /**
     * Is null giocatore boolean.
     *
     * @return the boolean
     */
    public Boolean isNullGiocatore() {
        return giocatore==null;
    }

    /**
     * Vendi azione.
     *
     * @param societa      the societa
     * @param valoreAzione the valore azione
     * @param quantita     the quantita
     */
    public void vendiAzione(String societa, Double valoreAzione, int quantita) {
        giocatore.vendiAzione(societa, valoreAzione, listino, quantita);
    }
}
