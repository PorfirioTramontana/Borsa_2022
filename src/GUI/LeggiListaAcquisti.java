package GUI;

import Controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Leggi lista acquisti.
 */
public class LeggiListaAcquisti {
    /**
     * The Frame.
     */
    public JFrame frame;
    private JPanel panel1;
    private JTable listaAcquistiTable;
    private JButton returnToHomeButton;

    /**
     * Instantiates a new Leggi lista acquisti.
     *
     * @param controller     the controller
     * @param frameChiamante the frame chiamante
     */
    public LeggiListaAcquisti(Controller controller, JFrame frameChiamante) {
        frame = new JFrame("Leggi Listino societa");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(frame);

        listaAcquistiTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Societa", "Valore Azione", "Quantita'"
                }
        ));
        DefaultTableModel model = (DefaultTableModel) listaAcquistiTable.getModel();
        ArrayList listaNomiSocieta = controller.getNomiSocietaAcquisti();
        ArrayList listaValoriAzione = controller.getValoriAzioneAcquisti();
        ArrayList listaQuantita = controller.getQuantitaAcquisti();
        if (listaNomiSocieta!=null)
            for (int i=0;i<listaNomiSocieta.size();i++)
                model.addRow(new Object[]{listaNomiSocieta.get(i),listaValoriAzione.get(i),listaQuantita.get(i)});

        returnToHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });
    }
}
