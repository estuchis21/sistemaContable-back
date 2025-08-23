/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.Models;

/**
 *
 * @author esteb
 */
public class Cuentas {
    private String codigo;
    private String nombre;
    private int id_tipo_saldo;
    private float saldo;
    
    public Cuentas(){
       
    }

    public Cuentas(String codigo, String nombre, int id_tipo_saldo, long saldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.id_tipo_saldo = id_tipo_saldo;
        this.saldo = saldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_Tipo_saldo() {
        return id_tipo_saldo;
    }

    public void setIdTipo_saldo(int id_tipo_saldo) {
        this.id_tipo_saldo = id_tipo_saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
   
}
