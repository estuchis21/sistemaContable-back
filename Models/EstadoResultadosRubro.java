package sistemacontable.back.Models;

import java.math.BigDecimal;

public class EstadoResultadosRubro {
    private String rubro;
    private BigDecimal totalIngresos;
    private BigDecimal totalGastos;
    private BigDecimal resultadoRubro;

    public String getRubro() { return rubro; }
    public void setRubro(String rubro) { this.rubro = rubro; }

    public BigDecimal getTotalIngresos() { return totalIngresos; }
    public void setTotalIngresos(BigDecimal totalIngresos) { this.totalIngresos = totalIngresos; }

    public BigDecimal getTotalGastos() { return totalGastos; }
    public void setTotalGastos(BigDecimal totalGastos) { this.totalGastos = totalGastos; }

    public BigDecimal getResultadoRubro() { return resultadoRubro; }
    public void setResultadoRubro(BigDecimal resultadoRubro) { this.resultadoRubro = resultadoRubro; }
}
