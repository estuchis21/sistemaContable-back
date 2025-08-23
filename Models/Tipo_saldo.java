/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.Models;

/**
 *
 * @author Esteban
 */
public class Tipo_saldo {
    private int id_tipo_saldo;
    private String tipo_saldo;

    public Tipo_saldo(int id_tipo_saldo, String tipo_saldo) {
        this.id_tipo_saldo = id_tipo_saldo;
        this.tipo_saldo = tipo_saldo;
    }

    public int getId_tipo_saldo() {
        return id_tipo_saldo;
    }

    public void setId_tipo_saldo(int id_tipo_saldo) {
        this.id_tipo_saldo = id_tipo_saldo;
    }

    public String getTipo_saldo() {
        return tipo_saldo;
    }

    public void setTipo_saldo(String tipo_saldo) {
        this.tipo_saldo = tipo_saldo;
    }
    
    
    
}
