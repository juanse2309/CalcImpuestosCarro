package model;

/**
 * Modelo que representa un vehículo con sus atributos principales.
 * Patrón MVC - Capa Modelo
 * @author Juan Sebastian Novoa Cepeda
 */
public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private double valorComercial;
    private String cilindraje; // "pequeño", "mediano", "grande"

    public Vehiculo() {}

    public Vehiculo(String marca, String modelo, int anio, double valorComercial, String cilindraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.valorComercial = valorComercial;
        this.cilindraje = cilindraje;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public double getValorComercial() { return valorComercial; }
    public void setValorComercial(double valorComercial) { this.valorComercial = valorComercial; }

    public String getCilindraje() { return cilindraje; }
    public void setCilindraje(String cilindraje) { this.cilindraje = cilindraje; }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + anio + ")";
    }
}
