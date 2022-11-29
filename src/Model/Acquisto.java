package Model;

/**
 * The type Acquisto.
 */
public class Acquisto {
    private Azione azione;
    private int quantita;
    private float prezzo;
    private Giocatore giocatore;

    /**
     * Instantiates a new Acquisto.
     *
     * @param a the a
     * @param q the q
     * @param p the p
     * @param g the g
     */
    public Acquisto(Azione a, int q, float p, Giocatore g) {
        azione=a;
        quantita=q;
        prezzo=p;
        giocatore=g;
    }


    /**
     * Aggiorna liquidita.
     */
    public void aggiornaLiquidita() {
        giocatore.setLiquidita(giocatore.getLiquidita()-prezzo*quantita);
    }

    /**
     * Gets quantita.
     *
     * @return the quantita
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * Gets prezzo.
     *
     * @return the prezzo
     */
    public float getPrezzo() {
        return prezzo;
    }

    /**
     * Gets azione.
     *
     * @return the azione
     */
    public Azione getAzione() {
        return azione;
    }

    /**
     * Sets quantita.
     *
     * @param i the
     */
    public void setQuantita(int i) {
        quantita=i;
    }
}
