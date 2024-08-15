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
import java.util.ArrayList;

public class App_Manejadordeprocesos {
    private JFrame frame;
    private ConfiguracionProcesos configuracionProcesos;
    private ConfiguracionSO configuracionSO;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                App_Manejadordeprocesos window = new App_Manejadordeprocesos();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public App_Manejadordeprocesos() {
        frame = new JFrame("Menú Principal");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 10));

        // Fondo de la ventana
        frame.getContentPane().setBackground(new Color(240, 248, 255)); // Alice Blue

        // Botón para Configuración de Procesos
        JButton btnProcesos = createStyledButton("Configuración de Procesos");
        btnProcesos.addActionListener(e -> {
            configuracionProcesos = new ConfiguracionProcesos();
            configuracionProcesos.setVisible(true);
        });
        frame.getContentPane().add(btnProcesos);

        // Botón para Definición de Lista de Ejecución
        JButton btnDefinicionLista = createStyledButton("Definición de Lista de Ejecución");
        btnDefinicionLista.addActionListener(e -> {
            if (configuracionProcesos != null) {
                ArrayList<Proceso> listaProcesos = configuracionProcesos.getListaProcesos();
                DefinicionListaEjecucion frame = new DefinicionListaEjecucion(listaProcesos);
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frame, "Debe configurar procesos primero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        frame.getContentPane().add(btnDefinicionLista);

        // Botón para Configuración del SO
        JButton btnConfiguracionSO = createStyledButton("Configuración SO");
        btnConfiguracionSO.addActionListener(e -> {
            configuracionSO = new ConfiguracionSO();
            configuracionSO.setVisible(true);
        });
        frame.getContentPane().add(btnConfiguracionSO);

        // Botón para Emulación del Administrador de Tareas
        JButton btnEmulador = createStyledButton("Emulación del Administrador de Tareas");
        btnEmulador.addActionListener(e -> {
            if (configuracionSO != null && configuracionProcesos != null) {
                String metodoEjecucion = configuracionSO.getMetodoEjecucion();
                ArrayList<Proceso> listaProcesos = configuracionProcesos.getListaProcesos();
                EmuladorAdministradorTareas emulador = new EmuladorAdministradorTareas(listaProcesos, metodoEjecucion);
                emulador.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frame, "Debe configurar procesos y el SO primero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        frame.getContentPane().add(btnEmulador);

        // Botón para Salir
        JButton btnSalir = createStyledButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        frame.getContentPane().add(btnSalir);
    }

    // Método para crear botones con estilo
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 130, 180)); // Steel Blue
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(250, 40));
        return button;
    }
}
