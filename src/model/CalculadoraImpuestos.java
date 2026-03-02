package model;

/**
 * Clase que calcula los impuestos de un vehículo según la normativa colombiana.
 * Patrón MVC - Capa Modelo (lógica de negocio)
 * @author Juan Sebastian Novoa Cepeda
 */
public class CalculadoraImpuestos {

    // Tarifas de impuesto según cilindraje (Ley 488 de 1998 - Colombia)
    private static final double TARIFA_PEQUENO  = 0.015; // hasta 1500 cc
    private static final double TARIFA_MEDIANO  = 0.025; // 1501 - 2500 cc
    private static final double TARIFA_GRANDE   = 0.035; // mayor a 2500 cc

    /**
     * Calcula el impuesto vehicular basado en el valor comercial y cilindraje.
     * @param vehiculo objeto Vehiculo con sus atributos
     * @return valor del impuesto calculado
     */
    public double calcularImpuesto(Vehiculo vehiculo) {
        double tarifa = obtenerTarifa(vehiculo.getCilindraje());
        return vehiculo.getValorComercial() * tarifa;
    }

    /**
     * Obtiene la tarifa según el tipo de cilindraje.
     * @param cilindraje tipo de cilindraje (pequeno, mediano, grande)
     * @return tarifa aplicable
     */
    private double obtenerTarifa(String cilindraje) {
        switch (cilindraje.toLowerCase()) {
            case "pequeno": return TARIFA_PEQUENO;
            case "mediano": return TARIFA_MEDIANO;
            case "grande":  return TARIFA_GRANDE;
            default:        return TARIFA_PEQUENO;
        }
    }

    /**
     * Retorna descripción de la tarifa aplicada.
     */
    public String getDescripcionTarifa(String cilindraje) {
        switch (cilindraje.toLowerCase()) {
            case "pequeno": return "1.5% - Cilindraje hasta 1500 cc";
            case "mediano": return "2.5% - Cilindraje 1501 a 2500 cc";
            case "grande":  return "3.5% - Cilindraje mayor a 2500 cc";
            default:        return "1.5% - Cilindraje hasta 1500 cc";
        }
    }
}
