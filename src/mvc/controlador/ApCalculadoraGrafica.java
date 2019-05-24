package mvc.controlador;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mvc.modelo.ProcesosCalculo;

public class ApCalculadoraGrafica {

    public TextField numero1;
    public TextField numero2;
    public Button botonSuma;
    public Button botonResta;
    public Button botonMultiplicar;
    public Button botonDividir;
    public Label resultado;
    private ProcesosCalculo procesosCalculo;

    /**
     * Constructor que inicializa la propiedad de los procesos de cálculo
     */
    public ApCalculadoraGrafica() {
        this.procesosCalculo = new ProcesosCalculo();
    }

    /**
     * Metodo principal del controlador
     * @param actionEvent Evento
     */
    public void ejecutar(ActionEvent actionEvent) {
        String operacion = extraerIdBoton(actionEvent);
        if (!numero1.getText().replace(" ","").isEmpty() && !numero2.getText().replace(" ","").isEmpty()) { //Comprueba si los campos de la calculadora no estan vacios
            try {
                double resultadoCalculo = calcular(operacion);
                imprimirResultado(resultadoCalculo);
            } catch (ArithmeticException ae) {
                resultado.setText(ae.getMessage());
            }
        }
    }

    /**
     * Método que calcula y devuelve la cifra dependiendo del valor pasado por parametros
     * @param operacion Botón pulsado por el usuario
     * @return Cifra obtenida por el cálculo
     * @throws ArithmeticException
     */
    private double calcular(String operacion) throws ArithmeticException{
        return procesosCalculo.calcular(operacion, Double.parseDouble(numero1.getText().replace(",", ".")), Double.parseDouble(numero2.getText().replace(",", ".")));
        //Llama al método calcular de los procesos, reemplazando el posible caracter "," por un ".", asi no saltará error al hacer la operación
    }

    /**
     * Dado el evento que activa la calculadora, saca la ID del botón para realizar la operación
     * @param actionEvent Evento
     * @return String
     */
    private String extraerIdBoton(ActionEvent actionEvent) {
        Button boton = (Button) actionEvent.getSource();
        return boton.getId();
    }

    /**
     * Evalúa el resultado e imprime según sea entero o decimal
     * @param resultado Resultado
     */
    private void imprimirResultado(double resultado) {
        String numero = String.valueOf(resultado);
        if (Double.parseDouble(numero.substring(numero.indexOf("."))) == 0) { //Comprueba si la parte decimal es un 0, para saber si es un entero o no
            this.resultado.setText(numero.substring(0, numero.indexOf(".")));
        } else {
            this.resultado.setText(String.valueOf(resultado));
        }
    }

}
