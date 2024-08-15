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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DefinicionListaEjecucion extends JFrame {
    private ArrayList<Proceso> listaProcesos;

    public DefinicionListaEjecucion(ArrayList<Proceso> listaProcesos) {
        this.listaProcesos = listaProcesos;

        setTitle("Definición de Lista de Ejecución");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Sin la columna "Uso CPU"
        String[] columnNames = {"Nombre", "Tiempo CPU", "Prioridad", "Instante de Llegada"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        for (Proceso p : listaProcesos) {
            tableModel.addRow(new Object[]{p.getNombre(), p.getTiempoCPU(), p.getPrioridad(), p.getInstanteLlegada()});
        }

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            dispose();
        });

        getContentPane().add(btnGuardar, BorderLayout.SOUTH);
    }
}
