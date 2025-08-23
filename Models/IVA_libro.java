package sistemacontable.back.Models;

public class IVA_libro {
    private int id_iva;
    private int id_operacion;
    private int id_tipo_libro;
    private double neto_gravado;
    private Double iva_21 = null;
    private Double iva_105 = null;
    private double total;

    public IVA_libro(int id_iva, int id_operacion, int id_tipo_libro, double neto_gravado, double total) {
        this.id_iva = id_iva;
        this.id_operacion = id_operacion;
        this.id_tipo_libro = id_tipo_libro;
        this.neto_gravado = neto_gravado;
        this.total = total;
    }

    // Getters y Setters
    public int getId_iva() { 
        return id_iva; 
    }
    
    
    public void setId_iva(int id_iva) { 
        this.id_iva = id_iva; 
    }

    public int getId_operacion() { 
        return id_operacion; 
    }
    
    public void setId_operacion(int id_operacion) { 
        this.id_operacion = id_operacion; 
    }

    public int getId_tipo_libro() { 
        return id_tipo_libro; 
    }
    
    public void setId_tipo_libro(int id_tipo_libro) { 
        this.id_tipo_libro = id_tipo_libro; 
    }

    public double getNeto_gravado() { 
        return neto_gravado; 
    }
    
    public void setNeto_gravado(double neto_gravado) { 
        this.neto_gravado = neto_gravado; 
    }

    public Double getIva_21() { 
        return iva_21; 
    }
    
    public void setIva_21(Double iva_21) { 
        this.iva_21 = iva_21; 
    }

    public Double getIva_105() { 
        return iva_105; 
    }
    
    public void setIva_105(Double iva_105) { 
        this.iva_105 = iva_105; 
    }

    public double getTotal() { 
        return total; 
    }
    
    public void setTotal(double total) { 
        this.total = total;
    }
}
