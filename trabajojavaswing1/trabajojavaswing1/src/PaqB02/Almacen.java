package PaqB02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Almacen extends JFrame {

    private JTextField numeroIdentificacion;
    private JTextField pesot;
    private JTextField empresaRemitente;
    private JTextField empresaReceptora;
    private JComboBox<String> comboBox1;
    private JRadioButton a1RadioButton;
    private JCheckBox inspeccionadoEnAduanasCheckBox;
    private JTextArea Estado;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JTextField numeroColumna;
    private JButton mostrarDatosContenedorButton;
    private JButton cuantosButton;
    private JTextField cuantos;
    private JPanel panel;
    private JTextArea descripcionContenido;
    private JButton crearButton;
    private JTextField MostrarDatos;
    private JTextField PaisProcedencia;
    private JTextField PrioridaD;
    private JTextField CuantosPaisProcedencia;
    private Puerto p;

    public Almacen() {
        setContentPane(panel);
        setTitle("Gestion de contenedores");
        setSize(1080, 720);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                p = new Puerto();
            }
        });

        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int id = Integer.parseInt(numeroIdentificacion.getText());
                    float peso = Float.parseFloat(pesot.getText());
                    String pais = PaisProcedencia.getText();
                    boolean aduana = inspeccionadoEnAduanasCheckBox.isSelected();
                    int prioridad = Integer.parseInt(PrioridaD.getText());
                    String descripcion = descripcionContenido.getText();
                    String envia = empresaRemitente.getText();
                    String recibe = empresaReceptora.getText();
                    Contenedor c = new Contenedor(id, peso, pais, aduana, prioridad, descripcion, envia, recibe);
                    p.apilarContenedor(c);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Debe introducir un número válido en los campos de identificación y peso.");
                }
            }
        });

        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (p != null) {
                    try {
                        int columna = Integer.parseInt(numeroColumna.getText());
                        p.desapilarContenedor(columna);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debe introducir un número válido en el campo de número de columna.");
                    }
                }
            }
        });

        mostrarDatosContenedorButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (p != null) {
                    try {
                        int id = Integer.parseInt(numeroIdentificacion.getText());
                        MostrarDatos.setText(String.valueOf(p.mostrarDatos(id)));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debe introducir un número válido en el campo de identificación.");
                    }
                }
            }
        });

        cuantosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (p != null) {
                    String pais = PaisProcedencia.getText();
                    CuantosPaisProcedencia.setText(pais);
                    int contador = p.cuentaContenedores(pais);
                    cuantos.setText(String.valueOf(contador));
                }
            }
        });




        // Creo el  botón
        JButton pesoTotalButton = new JButton("Peso total del hub");
        pesoTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calculo el peso del hub
                float pesoTotal = p.pesoTotalHub();

                // aqui creo la ventana para mostrar el peso total
                JFrame pesoTotalFrame = new JFrame();
                pesoTotalFrame.setSize(300, 150);
                pesoTotalFrame.setTitle("Peso total del hub");
                pesoTotalFrame.setVisible(true);

                // Creo el panel y label
                JPanel pesoTotalPanel = new JPanel();
                JLabel pesoTotalLabel = new JLabel("El peso total del hub es: " + pesoTotal);
                pesoTotalPanel.add(pesoTotalLabel);
                pesoTotalFrame.add(pesoTotalPanel);

                // Creo boton para cerrar la ventana
                JButton cerrarButton = new JButton("Cerrar");
                cerrarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pesoTotalFrame.dispose();
                    }
                });
                pesoTotalPanel.add(cerrarButton);
            }
        });
        panel.add(pesoTotalButton);

    }

    public static void main(String[] args) {
        Almacen contenedor1 = new Almacen();
    }
}



