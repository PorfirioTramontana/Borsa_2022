package GUI;

import Controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * The type Acquista azione.
 */
public class AcquistaAzione {
    /**
     * The Frame.
     */
    public JFrame frame;
    private JPanel panel1;
    private JTable listinoTable;
    private JButton acquistaButton;
    private String societa;
    private Double valoreAzione;

    /**
     * Instantiates a new Acquista azione.
     *
     * @param controller     the controller
     * @param frameChiamante the frame chiamante
     */
    public AcquistaAzione(Controller controller, JFrame frameChiamante) {
        frame = new JFrame("Acquista azione");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        listinoTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Societa", "Valore Azione"
                }
        ));
        DefaultTableModel model = (DefaultTableModel) listinoTable.getModel();
        ArrayList listaNomiSocieta = controller.getNomiSocietaDaListino();
        ArrayList listaValoriAzione = controller.getValoriAzionedaListino();
        if (listaNomiSocieta!=null)
            for (int i=0;i<listaNomiSocieta.size();i++)
                model.addRow(new Object[]{listaNomiSocieta.get(i),listaValoriAzione.get(i)});

        listinoTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = listinoTable.getSelectedRow();
                societa = (String) listinoTable.getValueAt(row, 0);
                valoreAzione = Double.parseDouble(listinoTable.getValueAt(row, 1).toString());
            }
        });
        acquistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (societa!=null) {
                    int quantita = Integer.parseInt(JOptionPane.showInputDialog("Inserisci la quantita' di azioni da acquistare"));
                    controller.acquistaAzione(societa, valoreAzione,quantita);
                    JOptionPane.showMessageDialog(frame, "Azione acquistata con successo");
                    frame.setVisible(false);
                    frameChiamante.setVisible(true);
                    frame.dispose();
                }
                else
                    JOptionPane.showMessageDialog(frame, "Selezionare una societa");
            }
        });
    }
}
