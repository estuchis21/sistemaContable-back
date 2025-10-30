package sistemacontable.back.Services;

import sistemacontable.back.DAO.EstadoResultadosDAO;
import sistemacontable.back.DAO.EstadoSituacionDAO;
import sistemacontable.back.Models.EstadoResultadosRubro;
import sistemacontable.back.Models.EstadoSituacionRubro;

import java.time.LocalDate;
import java.util.List;

public class EstadoService {

    private EstadoResultadosDAO resultadosDAO = new EstadoResultadosDAO();
    private EstadoSituacionDAO situacionDAO = new EstadoSituacionDAO();

    public List<EstadoResultadosRubro> obtenerEstadoResultados(LocalDate fechaCierre) {
        return resultadosDAO.getEstadoResultados(fechaCierre);
    }

    public List<EstadoSituacionRubro> obtenerEstadoSituacion(LocalDate fechaCierre) {
        return situacionDAO.getEstadoSituacion(fechaCierre);
    }
}
