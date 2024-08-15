/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_manejadordeprocesos;

/**
 *
 * @author henri
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConfiguracionProcesos extends JFrame {
   private ArrayList<Proceso> listaProcesos;

    public ConfiguracionProcesos() {
        setTitle("Configuración de Procesos");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listaProcesos = new ArrayList<>();
        getContentPane().setLayout(new GridLayout(0, 1));

        // Panel para agregar procesos
        JPanel panelAgregar = new JPanel();
        panelAgregar.setLayout(new GridLayout(0, 2));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblTiempoCPU = new JLabel("Tiempo CPU:");
        JTextField txtTiempoCPU = new JTextField();
        JLabel lblPrioridad = new JLabel("Prioridad:");
        JTextField txtPrioridad = new JTextField();
        JLabel lblInstanteLlegada = new JLabel("Instante de Llegada:");
        JTextField txtInstanteLlegada = new JTextField();

        panelAgregar.add(lblNombre);
        panelAgregar.add(txtNombre);
        panelAgregar.add(lblTiempoCPU);
        panelAgregar.add(txtTiempoCPU);
        panelAgregar.add(lblPrioridad);
        panelAgregar.add(txtPrioridad);
        panelAgregar.add(lblInstanteLlegada);
        panelAgregar.add(txtInstanteLlegada);

        getContentPane().add(panelAgregar);

        // Botón para agregar proceso
        JButton btnAgregar = new JButton("Agregar Proceso");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    int tiempoCPU = Integer.parseInt(txtTiempoCPU.getText());
                    int prioridad = Integer.parseInt(txtPrioridad.getText());
                    int instanteLlegada = Integer.parseInt(txtInstanteLlegada.getText());

                    // Establecer uso de CPU predeterminado
                    int usoCPU = tiempoCPU; // Puedes cambiar la lógica si lo deseas

                    Proceso proceso = new Proceso(nombre, tiempoCPU, prioridad, instanteLlegada, usoCPU);
                    listaProcesos.add(proceso);
                    JOptionPane.showMessageDialog(null, "Proceso agregado.");
                    txtNombre.setText("");
                    txtTiempoCPU.setText("");
                    txtPrioridad.setText("");
                    txtInstanteLlegada.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getContentPane().add(btnAgregar);
    }

    public ArrayList<Proceso> getListaProcesos() {
        return listaProcesos;
    }
}