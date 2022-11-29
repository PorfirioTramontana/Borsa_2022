package Model;

import java.util.ArrayList;

/**
 * The type Listino.
 */
public class Listino {
    private ArrayList<Societa> societa;

    /**
     * Instantiates a new Listino.
     */
    public Listino() {
        societa = new ArrayList<Societa>();
    }

    /**
     * Add societa.
     *
     * @param s the s
     */
    public void addSocieta(Societa s) {
        societa.add(s);
    }

    /**
     * Gets societa per nome.
     *
     * @param nome the nome
     * @return the societa per nome
     */
    public Societa getSocietaPerNome(String nome) {
        for (Societa s : societa) {
            if (s.getNome().equals(nome)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Gets societa.
     *
     * @param i the
     * @return the societa
     */
    public Societa getSocieta(int i) {
        return societa.get(i);
    }

    /**
     * Get lista societa array list.
     *
     * @return the array list
     */
    public ArrayList<Societa> getListaSocieta(){
        return societa;
    }

    /**
     * Aggiungi societa.
     *
     * @param text        the text
     * @param parseDouble the parse double
     */
    public void aggiungiSocieta(String text, double parseDouble) {
        Societa s = new Societa(text, parseDouble);
        societa.add(s);
    }

    /**
     * Gets nomi societa.
     *
     * @return the nomi societa
     */
    public ArrayList getNomiSocieta() {
        ArrayList<String> nomiSocieta = new ArrayList<String>();
        for (Societa s : societa) {
            nomiSocieta.add(s.getNome());
        }
        return nomiSocieta;
    }

    /**
     * Gets valori azione.
     *
     * @return the valori azione
     */
    public ArrayList getValoriAzione() {
        ArrayList<String> valoriSocieta = new ArrayList<String>();
        for (Societa s : societa) {
            valoriSocieta.add(s.getValoreAzione().toString());
        }
        return valoriSocieta;
    }

    /**
     * Gets valore azione.
     *
     * @param text the text
     * @return the valore azione
     */
    public Double getValoreAzione(String text) {
        for (Societa s : societa) {
            if (s.getNome().equals(text)) {
                return s.getValoreAzione();
            }
        }
        return null;
    }
}
