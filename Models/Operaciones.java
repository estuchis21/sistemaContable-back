package sistemacontable.back.Models;

public class Operaciones {
    private int id_asiento;
    private int id_cuenta;
    private int id_tipo_movimiento;
    private double monto;
    private String tipoLibro;
    private boolean iva21;
    private boolean iva105;
    private int id_operacion;

    public Operaciones(int id_asiento, int id_cuenta, int id_tipo_movimiento, double monto,
                       String tipoLibro, boolean iva21, boolean iva105) {
        this.id_asiento = id_asiento;
        this.id_cuenta = id_cuenta;
        this.id_tipo_movimiento = id_tipo_movimiento;
        this.monto = monto;
        this.tipoLibro = tipoLibro;
        this.iva21 = iva21;
        this.iva105 = iva105;
    }

    public int getId_asiento() { return id_asiento; }
    public int getId_cuenta() { return id_cuenta; }
    public int getId_tipo_movimiento() { return id_tipo_movimiento; }
    public double getMonto() { return monto; }
    public String getTipoLibro() { return tipoLibro; }
    public boolean isIva21() { return iva21; }
    public boolean isIva105() { return iva105; }
    public void setId_operacion(int id_operacion) { this.id_operacion = id_operacion; }
    public int getId_operacion() { return id_operacion; }
}
