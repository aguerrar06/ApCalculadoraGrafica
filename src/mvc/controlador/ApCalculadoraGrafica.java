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
     * Constructor que inicializa la propiedad de los procesos de calculo
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
                resultado.setText(String.valueOf(resultadoCalculo));
            } catch (ArithmeticException ae) {
                resultado.setText(ae.getMessage());
            }
        }
    }

    /**
     * Metodo que calcula y devuelve la cifra dependiendo del valor pasado por parametros
     * @param operacion Boton pulsado por el usuario
     * @return Cifra obtenida por el calculo
     * @throws ArithmeticException
     */
    private double calcular(String operacion) throws ArithmeticException{
        return procesosCalculo.calcular(operacion, Double.parseDouble(numero1.getText()), Double.parseDouble(numero2.getText()));
    }

    /**
     * Dado el evento que activa la calculadora, saca la ID del boton para realizar la operacion
     * @param actionEvent Evento
     * @return String
     */
    private String extraerIdBoton(ActionEvent actionEvent) {
        Button boton = (Button) actionEvent.getSource();
        return boton.getId();
    }

}
