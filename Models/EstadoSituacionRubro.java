package sistemacontable.back.Models;

import java.math.BigDecimal;

public class EstadoSituacionRubro {
    private String rubro;
    private BigDecimal totalActivos;
    private BigDecimal totalPasivos;
    private BigDecimal totalPatrimonio;

    public String getRubro() { return rubro; }
    public void setRubro(String rubro) { this.rubro = rubro; }

    public BigDecimal getTotalActivos() { return totalActivos; }
    public void setTotalActivos(BigDecimal totalActivos) { this.totalActivos = totalActivos; }

    public BigDecimal getTotalPasivos() { return totalPasivos; }
    public void setTotalPasivos(BigDecimal totalPasivos) { this.totalPasivos = totalPasivos; }

    public BigDecimal getTotalPatrimonio() { return totalPatrimonio; }
    public void setTotalPatrimonio(BigDecimal totalPatrimonio) { this.totalPatrimonio = totalPatrimonio; }
}
