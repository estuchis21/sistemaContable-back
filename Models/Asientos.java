package sistemacontable.back.Models;

import java.time.LocalDateTime;

public class Asientos {
    private int id_asiento;
    private String descripcion;
    private LocalDateTime fecha_asiento;

    public Asientos() {}

    public Asientos(String descripcion) {
        this.descripcion = descripcion;
        this.fecha_asiento = LocalDateTime.now();
    }

    // Getters y Setters
    public int getId_asiento() { return id_asiento; }
    public void setId_asiento(int id_asiento) { this.id_asiento = id_asiento; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDateTime getFecha_asiento() { return fecha_asiento; }
    public void setFecha_asiento(LocalDateTime fecha_asiento) { this.fecha_asiento = fecha_asiento; }
}
