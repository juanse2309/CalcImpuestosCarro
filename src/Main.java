import controller.VehiculoController;
import model.Vehiculo;
import model.CalculadoraImpuestos;
import view.VehiculoView;

import javax.swing.SwingUtilities;

/**
 * Clase principal - Punto de entrada de la aplicación.
 * Inicializa el patrón MVC: Modelo, Vista y Controlador.
 * @author Juan Sebastian Novoa Cepeda
 * Desarrollo de Software - Universidad EAN 2026
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear instancias del patrón MVC
            Vehiculo modelo = new Vehiculo();
            CalculadoraImpuestos calculadora = new CalculadoraImpuestos();
            VehiculoView vista = new VehiculoView();

            // El controlador conecta modelo y vista
            VehiculoController controller = new VehiculoController(modelo, calculadora, vista);

            // Mostrar la ventana principal
            vista.setVisible(true);
        });
    }
}
