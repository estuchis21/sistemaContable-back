package sistemacontable.back.Models;

import java.time.LocalDateTime;   // Para fecha + hora

public class Asientos {
    private int id_asiento;
    private LocalDateTime fecha_asiento; 
    private String descripcion;
    
    public Asientos() {}

    public Asientos(int id_asiento, LocalDateTime fecha_asiento, String descripcion) {
        this.id_asiento = id_asiento;
        this.fecha_asiento = fecha_asiento;
        this.descripcion = descripcion;
    }

    public int getId_asiento() {
        return id_asiento;
    }

    public void setId_asiento(int id_asiento) {
        this.id_asiento = id_asiento;
    }

    public LocalDateTime getFecha_asiento() {
        return fecha_asiento;
    }

    public void setFecha_asiento(LocalDateTime fecha_asiento) {
        this.fecha_asiento = fecha_asiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
