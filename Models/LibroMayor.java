package sistemacontable.back.Models;

import java.time.LocalDateTime;

public class LibroMayor {
    private int idAsiento;
    private LocalDateTime fechaAsiento;
    private String descripcion;
    private int idTipoMovimiento;
    private String tipoSaldo;
    private double movimiento;        // monto del DEBE/HABER positivo o negativo
    private double saldoAcumulado;    // saldo acumulado
    private String tipoSaldoFinal;    // DEUDOR o ACREEDOR

    // Constructor
    public LibroMayor(int idAsiento, LocalDateTime fechaAsiento, String descripcion, int idTipoMovimiento, 
                      String tipoSaldo, double movimiento, double saldoAcumulado, String tipoSaldoFinal) {
        this.idAsiento = idAsiento;
        this.fechaAsiento = fechaAsiento;
        this.descripcion = descripcion;
        this.idTipoMovimiento = idTipoMovimiento;
        this.tipoSaldo = tipoSaldo;
        this.movimiento = movimiento;
        this.saldoAcumulado = saldoAcumulado;
        this.tipoSaldoFinal = tipoSaldoFinal;
    }

    // Getters y Setters
    public int getIdAsiento() { return idAsiento; }
    public void setIdAsiento(int idAsiento) { this.idAsiento = idAsiento; }

    public LocalDateTime getFechaAsiento() { return fechaAsiento; }
    public void setFechaAsiento(LocalDateTime fechaAsiento) { this.fechaAsiento = fechaAsiento; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getIdTipoMovimiento() { return idTipoMovimiento; }
    public void setIdTipoMovimiento(int idTipoMovimiento) { this.idTipoMovimiento = idTipoMovimiento; }

    public String getTipoSaldo() { return tipoSaldo; }
    public void setTipoSaldo(String tipoSaldo) { this.tipoSaldo = tipoSaldo; }

    public double getMovimiento() { return movimiento; }
    public void setMovimiento(double movimiento) { this.movimiento = movimiento; }

    public double getSaldoAcumulado() { return saldoAcumulado; }
    public void setSaldoAcumulado(double saldoAcumulado) { this.saldoAcumulado = saldoAcumulado; }

    public String getTipoSaldoFinal() { return tipoSaldoFinal; }
    public void setTipoSaldoFinal(String tipoSaldoFinal) { this.tipoSaldoFinal = tipoSaldoFinal; }
}
