package GUI;

import Controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Leggi listino.
 */
public class LeggiListino {
    private JPanel panel1;
    private JTable table1;
    private JButton returnToHomeButton;
    /**
     * The Frame.
     */
    JFrame frame;

    /**
     * Instantiates a new Leggi listino.
     *
     * @param controller     the controller
     * @param frameChiamante the frame chiamante
     */
    public LeggiListino(Controller controller, JFrame frameChiamante) {
        frame = new JFrame("Leggi Listino societa");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(frameChiamante);
        returnToHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        //crea la tabella
        //table1 = new JTable();
        table1.setModel(new DefaultTableModel(
                 new Object[][] {
                 },
                    new String[] {
                            "Societa", "Valore Azione"
                    }
        ));
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        ArrayList listaNomiSocieta = controller.getNomiSocietaDaListino();
        ArrayList listaValoriAzione = controller.getValoriAzionedaListino();
        if (listaNomiSocieta!=null)
            for (int i=0;i<listaNomiSocieta.size();i++)
                 model.addRow(new Object[]{listaNomiSocieta.get(i),listaValoriAzione.get(i)});
    }
}
