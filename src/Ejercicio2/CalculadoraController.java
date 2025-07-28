package Ejercicio2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraController {
    private final CalculadoraView vista;
    private final CalculadoraModel modelo;

    public CalculadoraController(CalculadoraView vista, CalculadoraModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        agregarEventos();
    }

    private void agregarEventos() {
        vista.suma.addActionListener(e -> operarBinaria("+"));
        vista.resta.addActionListener(e -> operarBinaria("-"));
        vista.multiplicar.addActionListener(e -> operarBinaria("*"));
        vista.dividir.addActionListener(e -> operarBinaria("/"));

        vista.seno.addActionListener(e -> operarUnaria("sin"));
        vista.coseno.addActionListener(e -> operarUnaria("cos"));
        vista.tangente.addActionListener(e -> operarUnaria("tan"));
        vista.raiz.addActionListener(e -> operarUnaria("√"));
        vista.log.addActionListener(e -> operarUnaria("ln"));

        vista.binario.addActionListener(e -> {
            try {
                int dec = Integer.parseInt(vista.entrada.getText());
                vista.salida.setText("Binario: " + modelo.decimalABinario(dec));
            } catch (Exception ex) {
                mostrarError("Entrada inválida para binario.");
            }
        });

        vista.decimal.addActionListener(e -> {
            try {
                String bin = vista.entrada.getText();
                vista.salida.setText("Decimal: " + modelo.binarioADecimal(bin));
            } catch (Exception ex) {
                mostrarError("Binario inválido.");
            }
        });

        vista.hexadecimal.addActionListener(e -> {
            try {
                String hex = vista.entrada.getText();
                vista.salida.setText("Decimal: " + modelo.hexadecimalADecimal(hex));
            } catch (Exception ex) {
                mostrarError("Hexadecimal inválido.");
            }
        });

        vista.limpiar.addActionListener(e -> {
            vista.entrada.setText("");
            vista.salida.setText("");
        });
    }

    private void operarBinaria(String operador) {
        try {
            String[] valores = vista.entrada.getText().split(",");
            double a = Double.parseDouble(valores[0]);
            double b = Double.parseDouble(valores[1]);
            double resultado = switch (operador) {
                case "+" -> modelo.sumar(a, b);
                case "-" -> modelo.restar(a, b);
                case "*" -> modelo.multiplicar(a, b);
                case "/" -> modelo.dividir(a, b);
                default -> 0;
            };
            vista.salida.setText("Resultado: " + resultado);
        } catch (Exception e) {
            mostrarError("Formato: número1,número2");
        }
    }

    private void operarUnaria(String funcion) {
        try {
            double valor = Double.parseDouble(vista.entrada.getText());
            double resultado = switch (funcion) {
                case "sin" -> modelo.seno(valor);
                case "cos" -> modelo.coseno(valor);
                case "tan" -> modelo.tangente(valor);
                case "√" -> modelo.raiz(valor);
                case "ln" -> modelo.logaritmo(valor);
                default -> 0;
            };
            vista.salida.setText("Resultado: " + resultado);
        } catch (Exception e) {
            mostrarError("Entrada inválida.");
        }
    }

    private void mostrarError(String mensaje) {
        vista.salida.setText("❌ " + mensaje);
    }
}
