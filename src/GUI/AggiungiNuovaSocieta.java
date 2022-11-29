package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Aggiungi nuova societa.
 */
public class AggiungiNuovaSocieta {
    /**
     * The Frame.
     */
    JFrame frame;
    private JPanel panel1;
    private JTextField nomeSocietaText;
    private JTextField valoreAzioneText;
    private JLabel nomeSocietaLabel;
    private JButton OKButton;
    private JButton annullaButton;

    /**
     * Instantiates a new Aggiungi nuova societa.
     *
     * @param controller     the controller
     * @param frameChiamante the frame chiamante
     */
    public AggiungiNuovaSocieta(Controller controller,JFrame frameChiamante) {
        frame = new JFrame("Aggiungi nuova società");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(frameChiamante);
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
                //aggiungere la società al listino
                controller.aggiungiSocietaListino(nomeSocietaText.getText(),Double.parseDouble(valoreAzioneText.getText()));
                frame.setVisible(false);
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });
    }


}
