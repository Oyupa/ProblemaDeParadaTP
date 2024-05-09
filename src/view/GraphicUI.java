package view;

import model.HaltChecker;
import model.Reverser;
import utils.IO.FileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicUI {
    private JPanel Aplicacion;
    private JButton countDownButton;
    private JButton reverserButton;
    private JButton countUpButton;
    private JTextPane textPane1;
    private JLabel LabelReverser;
    private JButton countUp10Button;
    private JButton countDown10Button;
    private JButton reverserReverserButton;
    private JLabel LabelHaltChecker;

    public GraphicUI() {
        this.countDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String programa = FileManager.leerFicheroPrograma("ejemplos/CountDown");
                Reverser reverser = new Reverser(programa);
                if (reverser.call()) {
                    textPane1.setText("Fin de ejecución");
                } else {
                    textPane1.setText("Bucle infinito");
                }
            }
        });
        this.reverserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String programa = FileManager.leerFicheroPrograma("ejemplos/ReverserEjemplo");
                Reverser reverser = new Reverser(programa);
                if (reverser.call()) {
                    textPane1.setText("Fin de ejecución");
                } else {
                    textPane1.setText("Bucle infinito");
                }
            }
        });
        this.countUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String programa = FileManager.leerFicheroPrograma("ejemplos/CountUp");
                Reverser reverser = new Reverser(programa);
                if (reverser.call()) {
                    textPane1.setText("Fin de ejecución");
                } else {
                    textPane1.setText("Bucle infinito");
                }
            }
        });
        this.countUp10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String programa = FileManager.leerFicheroPrograma("ejemplos/CountUp");
                HaltChecker haltChecker = new HaltChecker(programa, "10");
                if (haltChecker.call()) {
                    textPane1.setText("El programa se detiene");
                } else {
                    textPane1.setText("El programa entraría en bucle infinito");
                }
            }
        });

        this.countDown10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String programa = FileManager.leerFicheroPrograma("ejemplos/CountDown");
                HaltChecker haltChecker = new HaltChecker(programa, "10");
                if (haltChecker.call()) {
                    textPane1.setText("El programa se detiene");
                } else {
                    textPane1.setText("El programa entraría en bucle infinito");
                }
            }
        });

        this.reverserReverserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String programa = FileManager.leerFicheroPrograma("ejemplos/ReverserEjemplo");
                HaltChecker haltChecker = new HaltChecker(programa, programa);
                if (haltChecker.call()) {
                    textPane1.setText("El programa se detiene");
                } else {
                    textPane1.setText("El programa entraría en bucle infinito");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Problema de la parada de Alan Turing");
        frame.setContentPane(new GraphicUI().Aplicacion);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


}
