package Ejercicio2;


import javax.swing.*;
import java.awt.*;

public class CalculadoraView extends JFrame {

    // Componentes
    JTextField entrada = new JTextField(15);
    JTextArea salida = new JTextArea(4, 20);

    JButton suma = new JButton("+");
    JButton resta = new JButton("-");
    JButton multiplicar = new JButton("*");
    JButton dividir = new JButton("/");

    JButton seno = new JButton("sin");
    JButton coseno = new JButton("cos");
    JButton tangente = new JButton("tan");
    JButton raiz = new JButton("√");
    JButton log = new JButton("ln");

    JButton binario = new JButton("Dec→Bin");
    JButton decimal = new JButton("Bin→Dec");
    JButton hexadecimal = new JButton("Hex→Dec");

    JButton limpiar = new JButton("C");

    public CalculadoraView() {
        setTitle("Calculadora Científica");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel entrada y salida
        JPanel panelTop = new JPanel(new GridLayout(2, 1));
        panelTop.add(entrada);
        salida.setEditable(false);
        panelTop.add(new JScrollPane(salida));
        add(panelTop, BorderLayout.NORTH);

        // Panel botones
        JPanel panelBotones = new JPanel(new GridLayout(5, 3, 5, 5));
        panelBotones.add(suma);
        panelBotones.add(resta);
        panelBotones.add(multiplicar);
        panelBotones.add(dividir);

        panelBotones.add(seno);
        panelBotones.add(coseno);
        panelBotones.add(tangente);
        panelBotones.add(raiz);
        panelBotones.add(log);

        panelBotones.add(binario);
        panelBotones.add(decimal);
        panelBotones.add(hexadecimal);
        panelBotones.add(limpiar);

        add(panelBotones, BorderLayout.CENTER);
        setVisible(true);
    }
}
