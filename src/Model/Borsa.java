package Model;

import java.time.LocalTime;

/**
 * The type Borsa.
 */
public class Borsa {
    private String citta="New York";
    private LocalTime orarioApertura;
    private LocalTime orarioChiusura;
    private Listino listino;

    /**
     * Instantiates a new Borsa.
     *
     * @param l the l
     */
    public Borsa(Listino l) {
        orarioApertura= LocalTime.of(9,30);
        orarioChiusura=LocalTime.of(16,0);
        listino=l;
    }

    /**
     * Gets listino.
     *
     * @return the listino
     */
    public Listino getListino() {
        return listino;
    }

    /**
     * Sets citta.
     *
     * @param text the text
     */
    public void setCitta(String text) {
        citta=text;
    }

    public String getCitta() {
        return citta;
    }
}
