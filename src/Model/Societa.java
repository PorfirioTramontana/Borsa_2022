package Model;

/**
 * The type Societa.
 */
public class Societa {
    private Double valoreAzione;
    private String nome;

    /**
     * Instantiates a new Societa.
     *
     * @param n      the n
     * @param valore the valore
     */
    public Societa(String n, double valore) {
        nome=n;
        valoreAzione = valore;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }


    /**
     * Gets valore azione.
     *
     * @return the valore azione
     */
    public Double getValoreAzione() {
        return valoreAzione;
    }

    /**
     * Sets valore azione.
     *
     * @param parseDouble the parse double
     */
    public void setValoreAzione(double parseDouble) {
        valoreAzione=parseDouble;
    }
}
