/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.Models;

import java.math.BigDecimal;

/**
 *
 * @author esteb
 */
public class Cuentas {
    private int id_cuenta;
    private String codigo;
    private String nombre;
    private int id_tipo_saldo;
    private BigDecimal saldo;
    
    public Cuentas(){
       
    }

    public Cuentas(int id_cuenta, String codigo, String nombre, int id_tipo_saldo, BigDecimal saldo) {
        this.id_cuenta = id_cuenta;
        this.codigo = codigo;
        this.nombre = nombre;
        this.id_tipo_saldo = id_tipo_saldo;
        this.saldo = saldo;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_tipo_saldo() {
        return id_tipo_saldo;
    }

    public void setId_tipo_saldo(int id_tipo_saldo) {
        this.id_tipo_saldo = id_tipo_saldo;
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
   
}
