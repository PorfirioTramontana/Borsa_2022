package GUI;

import Controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Vendi azione da lista.
 */
public class VendiAzioneDaLista {
    /**
     * The Frame.
     */
    JFrame frame;
    private JPanel panel1;
    private JTable ListaAcquistiTable;
    private JButton vendiAzioneButton;
    private JButton annullaButton;

    /**
     * Instantiates a new Vendi azione da lista.
     *
     * @param controller     the controller
     * @param frameChiamante the frame chiamante
     */
    public VendiAzioneDaLista(Controller controller, JFrame frameChiamante) {
        frame = new JFrame("Vendi Azione");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(frameChiamante);
        frame.setVisible(true);
        frameChiamante.setVisible(false);
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });



        //crea la tabella
        ListaAcquistiTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "Societa", "Valore Azione", "Quantita"
                }
        ));
        DefaultTableModel model = (DefaultTableModel) ListaAcquistiTable.getModel();
        ArrayList listaNomiSocieta = controller.getNomiSocietaDaListino();
        ArrayList listaValoriAzione = controller.getValoriAzionedaListino();
        ArrayList listaQuantita = controller.getQuantitaAcquisti();
        if (listaNomiSocieta!=null)
            for (int i=0;i<listaNomiSocieta.size();i++)
                model.addRow(new Object[]{listaNomiSocieta.get(i),listaValoriAzione.get(i),listaQuantita.get(i)});


        vendiAzioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = ListaAcquistiTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(frame, "Selezionare una riga");
                } else {
                    String societa = (String) ListaAcquistiTable.getValueAt(row, 0);
                    Double valoreAzione = Double.parseDouble(ListaAcquistiTable.getValueAt(row, 1).toString());
                    Double quantitaMax = Double.parseDouble(ListaAcquistiTable.getValueAt(row, 2).toString());
                    int quantita= Integer.parseInt(JOptionPane.showInputDialog(frame, "Inserire la quantita da vendere (max "+quantitaMax+")"));
                    controller.vendiAzione(societa, valoreAzione, quantita);
                    JOptionPane.showMessageDialog(frame, "Azione venduta");
                    frame.setVisible(false);
                    frameChiamante.setVisible(true);
                    frame.dispose();
                }
            }
        });
    }
}
