package sistemacontable.back.Services;

import sistemacontable.back.Interfaces.LibroDiarioI;
import sistemacontable.back.Models.Asientos;
import sistemacontable.back.Models.Operaciones;
import sistemacontable.back.DAO.LibroDiarioDAO;

public class LibroDiario implements LibroDiarioI {

    private final LibroDiarioDAO libroDiarioDAO = new LibroDiarioDAO();

    @Override
    public Asientos selectAsientoPorId(int id_asiento) {
        return libroDiarioDAO.selectAsientoPorId(id_asiento);
    }

    @Override
    public boolean existeAsiento(int id_asiento) {
        return libroDiarioDAO.existeAsiento(id_asiento);
    }

    @Override
    public boolean generarAsiento(Asientos asientos) {
        return libroDiarioDAO.generarAsiento(asientos);
    }

    @Override
    public boolean generarOperacionPorAsiento(Operaciones operaciones) {
        return libroDiarioDAO.generarOperacionPorAsiento(operaciones);
    }
}
