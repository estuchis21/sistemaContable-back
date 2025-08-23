package sistemacontable.back.Models;

import java.math.BigDecimal;

public class Operaciones {
    private int id_operacion;           // Generado por la base de datos
    private int id_asiento;             // Referencia al asiento
    private int id_cuenta;              // Cuenta contable
    private int id_tipo_movimiento;     // Tipo de movimiento (débito/crédito)
    private BigDecimal monto;           // Monto neto
    private String tipo_libro;          // Ej: "Diario", "Mayor"
    private boolean calcular_iva_21;    // True si se calcula IVA 21%
    private boolean calcular_iva_10_5;  // True si se calcula IVA 10.5%

    // -------------------------
    // Constructores
    // -------------------------
    public Operaciones() {}

    public Operaciones(int id_asiento, int id_cuenta, int id_tipo_movimiento, BigDecimal monto, String tipo_libro, boolean calcular_iva_21, boolean calcular_iva_10_5) {
        this.id_asiento = id_asiento;
        this.id_cuenta = id_cuenta;
        this.id_tipo_movimiento = id_tipo_movimiento;
        this.monto = monto;
        this.tipo_libro = tipo_libro;
        this.calcular_iva_21 = calcular_iva_21;
        this.calcular_iva_10_5 = calcular_iva_10_5;
    }

    // -------------------------
    // Getters y Setters
    // -------------------------
    public int getId_operacion() {
        return id_operacion;
    }

    public void setId_operacion(int id_operacion) {
        this.id_operacion = id_operacion;
    }

    public int getId_asiento() {
        return id_asiento;
    }

    public void setId_asiento(int id_asiento) {
        this.id_asiento = id_asiento;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_tipo_movimiento() {
        return id_tipo_movimiento;
    }

    public void setId_tipo_movimiento(int id_tipo_movimiento) {
        this.id_tipo_movimiento = id_tipo_movimiento;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipo_libro() {
        return tipo_libro;
    }

    public void setTipo_libro(String tipo_libro) {
        this.tipo_libro = tipo_libro;
    }

    public boolean isCalcular_iva_21() {
        return calcular_iva_21;
    }

    public void setCalcular_iva_21(boolean calcular_iva_21) {
        this.calcular_iva_21 = calcular_iva_21;
    }

    public boolean isCalcular_iva_10_5() {
        return calcular_iva_10_5;
    }

    public void setCalcular_iva_10_5(boolean calcular_iva_10_5) {
        this.calcular_iva_10_5 = calcular_iva_10_5;
    }
}
