package Model;

/**
 * The type Azione.
 */
public class Azione {
    private float prezzo;
    private Societa societa;

    /**
     * Instantiates a new Azione.
     *
     * @param s the s
     * @param p the p
     */
    public Azione(Societa s, float p) {
        societa=s;
        prezzo=p;
    }

    /**
     * Instantiates a new Azione.
     *
     * @param societa      the societa
     * @param valoreAzione the valore azione
     * @param listino      the listino
     */
    public Azione(String societa, Double valoreAzione, Listino listino) {
        this.societa = listino.getSocietaPerNome(societa);
        this.prezzo = valoreAzione.floatValue();
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
     * Sets prezzo.
     *
     * @param v the v
     */
    public void setPrezzo(float v) {
        prezzo=v;
    }

    /**
     * Gets societa.
     *
     * @return the societa
     */
    public Societa getSocieta() {
        return societa;
    }
}
