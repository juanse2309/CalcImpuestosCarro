package controller;

import model.Vehiculo;
import model.CalculadoraImpuestos;
import view.VehiculoView;

/**
 * Controlador que coordina la interacción entre el Modelo y la Vista.
 * Patrón MVC - Capa Controlador
 * @author Juan Sebastian Novoa Cepeda
 */
public class VehiculoController {

    private Vehiculo modelo;
    private CalculadoraImpuestos calculadora;
    private VehiculoView vista;

    public VehiculoController(Vehiculo modelo, CalculadoraImpuestos calculadora, VehiculoView vista) {
        this.modelo = modelo;
        this.calculadora = calculadora;
        this.vista = vista;
        this.vista.setController(this);
    }

    /**
     * Procesa los datos ingresados por el usuario y calcula el impuesto.
     */
    public void calcular() {
        try {
            String marca = vista.getMarca();
            String modeloAuto = vista.getModeloAuto();
            int anio = Integer.parseInt(vista.getAnio());
            double valor = Double.parseDouble(vista.getValorComercial());
            String cilindraje = vista.getCilindraje();

            if (marca.isEmpty() || modeloAuto.isEmpty()) {
                vista.mostrarError("Por favor complete todos los campos.");
                return;
            }

            modelo.setMarca(marca);
            modelo.setModelo(modeloAuto);
            modelo.setAnio(anio);
            modelo.setValorComercial(valor);
            modelo.setCilindraje(cilindraje);

            double impuesto = calculadora.calcularImpuesto(modelo);
            String descripcion = calculadora.getDescripcionTarifa(cilindraje);

            vista.mostrarResultado(modelo, impuesto, descripcion);

        } catch (NumberFormatException e) {
            vista.mostrarError("El año y el valor comercial deben ser números válidos.");
        }
    }

    /**
     * Limpia los campos del formulario.
     */
    public void limpiar() {
        vista.limpiarCampos();
    }
}
