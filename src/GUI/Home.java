package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * The type Home.
 */
public class Home {
    private Controller controller;

    private JPanel panel1;
    private static JFrame frame;
    private JButton nomeDelGiocatoreButton;
    private JLabel giocatoreText;
    private JButton cittàDellaBorsaButton;
    private JLabel cittaBorsaText;
    private JButton aggiungiNuovaSocietaButton;
    private JButton leggiListinoButton;
    private JButton modificaValoreAzioneButton;
    private JButton acquistaAzioneButton;
    private JButton leggiListaAcquistiButton;
    private JLabel disponibilitaLabel;
    private JLabel bilancioLabel;
    private JButton vendiAzioneButton;

    /**
     * Instantiates a new Home.
     */
    public Home() {
        //crea un oggetto controller che gestisce le operazioni
        controller= new Controller();

        nomeDelGiocatoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s= JOptionPane.showInputDialog("Inserisci il nome del giocatore");
                giocatoreText.setText("Benvenuto, "+s);
                //salvare il nome del giocatore
                controller.setNomeGiocatore(s);
                aggiorna();
            }
        });
        cittàDellaBorsaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s= JOptionPane.showInputDialog("Inserisci la città della borsa");
                cittaBorsaText.setText("Si gioca su "+s);
                //salvare il nome della città della borsa
                controller.setCittaBorsa(s);
            }
        });
        aggiungiNuovaSocietaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AggiungiNuovaSocieta aggiungiNuovaSocieta = new AggiungiNuovaSocieta(controller,frame);
                aggiungiNuovaSocieta.frame.setVisible(true);
                frame.setVisible(false);

            }
        });
        leggiListinoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeggiListino leggiListino = new LeggiListino(controller,frame);
                leggiListino.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        modificaValoreAzioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificaValoreAzione modificaValoreAzione = new ModificaValoreAzione(controller,frame);
                modificaValoreAzione.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        acquistaAzioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcquistaAzione acquistaAzione = new AcquistaAzione(controller,frame);
                acquistaAzione.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        leggiListaAcquistiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeggiListaAcquisti leggiListaAcquisti = new LeggiListaAcquisti(controller,frame);
                leggiListaAcquisti.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        frame.addComponentListener(new ComponentAdapter() {
            public void componentHidden(ComponentEvent e) {
                /* code run when component hidden*/
            }
            public void componentShown(ComponentEvent e) {
                aggiorna();
            }
        });

        vendiAzioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VendiAzioneDaLista vendiAzioneDaLista = new VendiAzioneDaLista(controller,frame);
                vendiAzioneDaLista.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }

    /**
     * Aggiorna.
     */
    void aggiorna() {
        if (!controller.isNullGiocatore()) {
            disponibilitaLabel.setText("Disponibilita': " + controller.getDisponibilita());
            bilancioLabel.setText("Bilancio: " + controller.getBilancio());
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        frame = new JFrame("Home");
        frame.setContentPane(new Home().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
