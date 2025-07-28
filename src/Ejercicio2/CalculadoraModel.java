package Ejercicio2;


public class CalculadoraModel {

    // Operaciones básicas
    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) throw new ArithmeticException("División por cero");
        return a / b;
    }

    // Funciones científicas
    public double seno(double a) {
        return Math.sin(Math.toRadians(a));
    }

    public double coseno(double a) {
        return Math.cos(Math.toRadians(a));
    }

    public double tangente(double a) {
        return Math.tan(Math.toRadians(a));
    }

    public double raiz(double a) {
        return Math.sqrt(a);
    }

    public double logaritmo(double a) {
        return Math.log(a);
    }

    // Conversión numérica
    public String decimalABinario(int n) {
        return Integer.toBinaryString(n);
    }

    public int binarioADecimal(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public int hexadecimalADecimal(String hex) {
        return Integer.parseInt(hex, 16);
    }
}
