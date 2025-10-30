/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.Models;

/**
 *
 * @author Esteban
 */
public class Tipo_movimiento {
    private int id_tipo_movimiento;
    private String nombre;

    public Tipo_movimiento(int id_tipo_movimiento, String nombre) {
        this.id_tipo_movimiento = id_tipo_movimiento;
        this.nombre = nombre;
    }

    public int getId_tipo_movimiento() {
        return id_tipo_movimiento;
    }

    public void setId_tipo_movimiento(int id_tipo_movimiento) {
        this.id_tipo_movimiento = id_tipo_movimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
