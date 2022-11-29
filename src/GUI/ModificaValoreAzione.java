package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Modifica valore azione.
 */
public class ModificaValoreAzione {
    /**
     * The Frame.
     */
    JFrame frame;
    private JPanel panel1;
    private JLabel nomeSocietaLabel;
    private JTextField nomeSocietaText;
    private JTextField valoreAzioneText;
    private JButton OKButton;
    private JButton annullaButton;
    private JButton leggiValoreButton;

    private Controller controller;


    /**
     * Instantiates a new Modifica valore azione.
     *
     * @param controller     the controller
     * @param frameChiamante the frame chiamante
     */
    public ModificaValoreAzione(Controller controller, JFrame frameChiamante) {
        this.controller=controller;
        frame = new JFrame("Modifica valore azione");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //modificare il valore dell'azione
                Float valoreAzione = null;
                try{
                    valoreAzione=Float.parseFloat(valoreAzioneText.getText());
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Inserire un valore numerico","Errore",JOptionPane.ERROR_MESSAGE);
                }
                if (valoreAzione!=null) {
                    controller.modificaValoreAzione(nomeSocietaText.getText(), valoreAzione);
                    frame.setVisible(false);
                    frameChiamante.setVisible(true);
                    frame.dispose();
                }
            }
        });
        leggiValoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double valore= controller.getValoreAzione(nomeSocietaText.getText());
                //leggere il valore dell'azione
                if (valore!=null)
                    valoreAzioneText.setText(valore.toString());
                }
        });
    }
}

