package otf;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.*;

public class AuswahlDatei extends JFrame implements ActionListener {
    private JButton button = new JButton("Map-Copy (bsynnnn.cpy generieren aus Map (bsynnnn.bms)");
    private JLabel label = new JLabel("Keine Datei ausgewählt.");

    public AuswahlDatei() {
        setTitle("Datei-Auswahl");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 100);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);

        button.addActionListener(this);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("BMS-Datei (*.BMS) auswählen");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("BMS-Datei", "BMS");
        chooser.addChoosableFileFilter(filter);
        chooser.showOpenDialog(null);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            label.setText("Datei ausgewählt: " + chooser.getSelectedFile());
        } else {
            label.setText("Keine Datei ausgewählt.");
        }
    }

    public static void main(String[] args) {
        new AuswahlDatei();
    }
}
