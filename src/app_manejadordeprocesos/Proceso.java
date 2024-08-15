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

public class Proceso {
    private String nombre;
    private int tiempoCPU;
    private int prioridad;
    private int instanteLlegada;
    private int usoCPU;

    public Proceso(String nombre, int tiempoCPU, int prioridad, int instanteLlegada, int usoCPU) {
        this.nombre = nombre;
        this.tiempoCPU = tiempoCPU;
        this.prioridad = prioridad;
        this.instanteLlegada = instanteLlegada;
        this.usoCPU = usoCPU;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoCPU() {
        return tiempoCPU;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getInstanteLlegada() {
        return instanteLlegada;
    }

    public int getUsoCPU() {
        return usoCPU;
    }

    public void setUsoCPU(int usoCPU) {
        this.usoCPU = usoCPU;
    }
}
