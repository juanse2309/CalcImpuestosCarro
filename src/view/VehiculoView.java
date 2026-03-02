package view;

import controller.VehiculoController;
import model.Vehiculo;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Vista principal de la aplicación con interfaz gráfica Swing.
 * Patrón MVC - Capa Vista
 * @author Juan Sebastian Novoa Cepeda
 */
public class VehiculoView extends JFrame {

    private VehiculoController controller;

    // Componentes del formulario
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtAnio;
    private JTextField txtValorComercial;
    private JComboBox<String> comboCilindraje;
    private JTextArea txtResultado;
    private JButton btnCalcular;
    private JButton btnLimpiar;

    public VehiculoView() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Calculadora de Impuestos Vehicular - Universidad EAN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 520);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Título
        JLabel lblTitulo = new JLabel("Calculadora de Impuestos de Vehículo", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 8));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Vehículo"));

        panelFormulario.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        panelFormulario.add(txtMarca);

        panelFormulario.add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        panelFormulario.add(txtModelo);

        panelFormulario.add(new JLabel("Año:"));
        txtAnio = new JTextField();
        panelFormulario.add(txtAnio);

        panelFormulario.add(new JLabel("Valor Comercial ($):"));
        txtValorComercial = new JTextField();
        panelFormulario.add(txtValorComercial);

        panelFormulario.add(new JLabel("Cilindraje:"));
        String[] opciones = {"pequeno", "mediano", "grande"};
        comboCilindraje = new JComboBox<>(opciones);
        panelFormulario.add(comboCilindraje);

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnCalcular = new JButton("Calcular Impuesto");
        btnCalcular.setBackground(new Color(70, 130, 180));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 12));
        btnCalcular.addActionListener(e -> controller.calcular());

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(e -> controller.limpiar());

        panelBotones.add(btnCalcular);
        panelBotones.add(btnLimpiar);

        // Panel de resultado
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        txtResultado = new JTextArea(6, 40);
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtResultado.setBackground(new Color(245, 245, 245));
        panelResultado.add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        // Panel sur (botones + resultado)
        JPanel panelSur = new JPanel(new BorderLayout(5, 5));
        panelSur.add(panelBotones, BorderLayout.NORTH);
        panelSur.add(panelResultado, BorderLayout.CENTER);

        panelPrincipal.add(panelSur, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    // --- Métodos de acceso para el Controlador ---

    public void setController(VehiculoController controller) {
        this.controller = controller;
    }

    public String getMarca() { return txtMarca.getText().trim(); }
    public String getModeloAuto() { return txtModelo.getText().trim(); }
    public String getAnio() { return txtAnio.getText().trim(); }
    public String getValorComercial() { return txtValorComercial.getText().trim(); }
    public String getCilindraje() { return (String) comboCilindraje.getSelectedItem(); }

    public void mostrarResultado(Vehiculo v, double impuesto, String descripcion) {
        NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        txtResultado.setText(
            "Vehículo: " + v.toString() + "\n" +
            "Valor Comercial: " + fmt.format(v.getValorComercial()) + "\n" +
            "Tarifa aplicada: " + descripcion + "\n" +
            "=================================\n" +
            "IMPUESTO A PAGAR: " + fmt.format(impuesto)
        );
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void limpiarCampos() {
        txtMarca.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtValorComercial.setText("");
        comboCilindraje.setSelectedIndex(0);
        txtResultado.setText("");
    }
}
