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

    public ApCalculadoraGrafica() {
        this.procesosCalculo = new ProcesosCalculo();
    }

    public void calcular(ActionEvent actionEvent) {
        String operacion = extraerIdBoton(actionEvent);
        if (!numero1.getText().equals("") && !numero2.getText().equals("")) {
            try {
                double resultadoCalculo = procesosCalculo.calcular(operacion, Double.parseDouble(numero1.getText()), Double.parseDouble(numero2.getText()));
                resultado.setText(String.valueOf(resultadoCalculo));
            } catch (ArithmeticException ae) {
                resultado.setText(ae.getMessage());
            }
        }
    }

    private String extraerIdBoton(ActionEvent actionEvent) {
        Button boton = (Button) actionEvent.getSource();
        return boton.getId();
    }

}
