/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacontable.back.Models;

import java.time.LocalDateTime;

/**
 *
 * @author Esteban
 */
public class LibroMayor {
    private int idAsiento;
    private LocalDateTime fechaAsiento;
    private String descripcion;
    private int idTipoMovimiento;
    private String tipoSaldo;
    private double saldoAcumulado;

    // Constructor, getters y setters

    public LibroMayor(int idAsiento, LocalDateTime fechaAsiento, String descripcion, int idTipoMovimiento, String tipoSaldo, double saldoAcumulado) {
        this.idAsiento = idAsiento;
        this.fechaAsiento = fechaAsiento;
        this.descripcion = descripcion;
        this.idTipoMovimiento = idTipoMovimiento;
        this.tipoSaldo = tipoSaldo;
        this.saldoAcumulado = saldoAcumulado;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public LocalDateTime getFechaAsiento() {
        return fechaAsiento;
    }

    public void setFechaAsiento(LocalDateTime fechaAsiento) {
        this.fechaAsiento = fechaAsiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(int idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public String getTipoSaldo() {
        return tipoSaldo;
    }

    public void setTipoSaldo(String tipoSaldo) {
        this.tipoSaldo = tipoSaldo;
    }

    public double getSaldoAcumulado() {
        return saldoAcumulado;
    }

    public void setSaldoAcumulado(double saldoAcumulado) {
        this.saldoAcumulado = saldoAcumulado;
    }
    
    
    
}
