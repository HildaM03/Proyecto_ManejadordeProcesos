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

public class ConfiguracionSO extends JFrame {
    private String metodoEjecucion;
    private JComboBox<String> comboBoxMetodoEjecucion;

    public ConfiguracionSO() {
        setTitle("Configuración del SO");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(2, 1));

        JPanel panelMetodo = new JPanel();
        panelMetodo.setLayout(new FlowLayout());

        JLabel lblMetodoEjecucion = new JLabel("Método de Ejecución:");
        panelMetodo.add(lblMetodoEjecucion);

        comboBoxMetodoEjecucion = new JComboBox<>(new String[] {
            "Prioridad", "Tiempo de CPU", "Mixto", "Round Robin", "Múltiples Colas", "Garantizado", "Por Sorteo", "Partes Equitativas"
        });
        panelMetodo.add(comboBoxMetodoEjecucion);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodoEjecucion = (String) comboBoxMetodoEjecucion.getSelectedItem();
                dispose(); // Cierra la ventana después de guardar
            }
        });
        panelMetodo.add(btnGuardar);

        getContentPane().add(panelMetodo);
    }

    public String getMetodoEjecucion() {
        return metodoEjecucion;
    }
}
