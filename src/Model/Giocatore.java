package Model;

import java.util.ArrayList;

/**
 * The type Giocatore.
 */
public class Giocatore {
    private String nome;
    private float liquidita;
    private float disponibilitaIniziale=100000;

    private ArrayList<Acquisto> acquisti;

    /**
     * Instantiates a new Giocatore.
     *
     * @param s the s
     */
    public Giocatore(String s) {
        nome=s;
        liquidita=disponibilitaIniziale;
        acquisti = new ArrayList<Acquisto>();
    }

    /**
     * Gets liquidita.
     *
     * @return the liquidita
     */
    public float getLiquidita() {
        return liquidita;
    }

    /**
     * Sets liquidita.
     *
     * @param l the l
     */
    public void setLiquidita(float l) {
        liquidita=l;
    }

    /**
     * Acquista.
     *
     * @param azione   the azione
     * @param quantita the quantita
     */
    public void acquista(Azione azione, int quantita) {
        Acquisto a = new Acquisto(azione, quantita, azione.getPrezzo(), this);
        acquisti.add(a);
        a.aggiornaLiquidita();
    }

    /**
     * Calcola capitale float.
     *
     * @return the float
     */
    public float calcolaCapitale() {
        float capitale=liquidita;
        System.out.println(capitale);
            for (Acquisto a : acquisti) {
               capitale+=a.getAzione().getSocieta().getValoreAzione()*a.getQuantita();
            }
        System.out.println(capitale);
        return capitale;
    }

    /**
     * Acquista azione.
     *
     * @param societa      the societa
     * @param valoreAzione the valore azione
     * @param listino      the listino
     * @param quantita     the quantita
     */
    public void acquistaAzione(String societa, Double valoreAzione, Listino listino, int quantita) {
        Azione azione = new Azione(societa, valoreAzione, listino);
        acquista(azione, quantita);
    }

    /**
     * Gets acquisti.
     *
     * @return the acquisti
     */
    public ArrayList getAcquisti() {
        return acquisti;
    }

    /**
     * Vendi azione.
     *
     * @param societa      the societa
     * @param valoreAzione the valore azione
     * @param listino      the listino
     * @param quantita     the quantita
     */
    public void vendiAzione(String societa, Double valoreAzione, Listino listino, int quantita) {
        Acquisto a=cercaAcquisti(societa);
        if (a!=null) {
            if (a.getQuantita()>=quantita) {
                a.setQuantita(a.getQuantita()-quantita);
                liquidita+=valoreAzione*quantita;
            }
        }
    }

    private Acquisto cercaAcquisti(String societa) {
        for (Acquisto a : acquisti) {
            if (a.getAzione().getSocieta().getNome().equals(societa)) {
                return a;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }
}
