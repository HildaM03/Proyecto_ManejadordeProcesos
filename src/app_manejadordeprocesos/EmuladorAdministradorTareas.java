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

public class EmuladorAdministradorTareas extends JFrame {
    private ArrayList<Proceso> listaProcesos;
    private String metodoEjecucion;

    public EmuladorAdministradorTareas(ArrayList<Proceso> listaProcesos, String metodoEjecucion) {
        this.listaProcesos = listaProcesos;
        this.metodoEjecucion = metodoEjecucion;

        setTitle("Emulador del Administrador de Tareas");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // Panel para las barras de progreso
        JPanel panelBarras = new JPanel();
        panelBarras.setLayout(new GridLayout(listaProcesos.size(), 1));

        // Ajustar la ejecución según el método seleccionado
        if (metodoEjecucion.equals("Prioridad")) {
            calcularPorcentajePrioridad();
        } else if (metodoEjecucion.equals("Tiempo de CPU")) {
            calcularPorcentajeTiempoCPU();
        }

        // Agregar barras de progreso para cada proceso con colores llamativos
        Color[] colors = {new Color(255, 99, 71), new Color(50, 205, 50), new Color(30, 144, 255), new Color(255, 165, 0), new Color(138, 43, 226)};
        int colorIndex = 0;

        for (Proceso p : listaProcesos) {
            JProgressBar progressBar = new JProgressBar(0, 100);
            progressBar.setValue(p.getUsoCPU());
            progressBar.setStringPainted(true);
            progressBar.setString(p.getNombre() + " - " + p.getUsoCPU() + "%");
            progressBar.setForeground(colors[colorIndex % colors.length]);
            colorIndex++;

            JPanel panelProceso = new JPanel();
            panelProceso.setLayout(new BorderLayout());
            panelProceso.add(new JLabel(p.getNombre()), BorderLayout.WEST);
            panelProceso.add(progressBar, BorderLayout.CENTER);

            panelBarras.add(panelProceso);
        }

        getContentPane().add(panelBarras, BorderLayout.CENTER);

        // Etiqueta para mostrar el uso total de CPU
        JLabel lblUsoCPU = new JLabel("Uso Total CPU: 0%");
        getContentPane().add(lblUsoCPU, BorderLayout.SOUTH);

        // Actualizar el uso total de CPU
        actualizarProgreso(lblUsoCPU);
    }

    private void calcularPorcentajePrioridad() {
        // Calcular el total de prioridades
        int totalPrioridad = listaProcesos.stream().mapToInt(Proceso::getPrioridad).sum();

        // Calcular el porcentaje de uso de CPU para cada proceso basado en la prioridad
        for (Proceso p : listaProcesos) {
            int porcentajeCPU = (int) ((p.getPrioridad() / (double) totalPrioridad) * 100);
            p.setUsoCPU(porcentajeCPU);
        }

        // Ordenar los procesos por prioridad ascendente
        listaProcesos.sort((p1, p2) -> Integer.compare(p1.getPrioridad(), p2.getPrioridad()));
    }

    private void calcularPorcentajeTiempoCPU() {
        // Calcular el total de tiempo de CPU
        int totalTiempoCPU = listaProcesos.stream().mapToInt(Proceso::getTiempoCPU).sum();

        // Calcular el porcentaje de uso de CPU para cada proceso basado en el tiempo de CPU
        for (Proceso p : listaProcesos) {
            int porcentajeCPU = (int) ((p.getTiempoCPU() / (double) totalTiempoCPU) * 100);
            p.setUsoCPU(porcentajeCPU);
        }

        // Ordenar los procesos por tiempo de CPU descendente
        listaProcesos.sort((p1, p2) -> Integer.compare(p2.getTiempoCPU(), p1.getTiempoCPU()));
    }

    private void actualizarProgreso(JLabel lblUsoCPU) {
        int totalCPU = 0;
        for (Proceso proceso : listaProcesos) {
            totalCPU += proceso.getUsoCPU();
        }
        lblUsoCPU.setText("Uso Total CPU: " + totalCPU + "%");
    }

    public static void main(String[] args) {
        // Crear algunos ejemplos de procesos
        ArrayList<Proceso> procesos = new ArrayList<>();
        

        // Mostrar el emulador con el método de ejecución deseado
        EmuladorAdministradorTareas emulador = new EmuladorAdministradorTareas(procesos, "Tiempo de CPU");
        emulador.setVisible(true);
    }
}
