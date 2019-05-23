package mvc.modelo;

/**
 * Created by aguerrar06 on 23/05/2019.
 */
public class ProcesosCalculo {

    private double resultado;

    public double calcular(String operador, double numero1, double numero2) throws ArithmeticException{
        switch (operador) {
            case "botonSuma": sumar(numero1, numero2);break;
            case "botonResta": restar(numero1, numero2);break;
            case "botonMultiplicar": multiplicar(numero1, numero2);break;
            case "botonDividir": dividir(numero1, numero2);break;
        }
        return this.resultado;
    }

    private void sumar (double numero1, double numero2) {
        this.resultado = numero1 + numero2;
    }

    private void restar (double numero1, double numero2) {
        this.resultado = numero1 - numero2;
    }

    private void multiplicar (double numero1, double numero2) {
        this.resultado = numero1 * numero2;
    }

    private void dividir (double numero1, double numero2) throws ArithmeticException{
        if (numero2 == 0) {
            throw new ArithmeticException("No se puede dividir entre 0");
        } else {
            this.resultado = numero1 / numero2;
        }
    }

}
