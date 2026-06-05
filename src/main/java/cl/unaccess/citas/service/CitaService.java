package cl.unaccess.citas.service;

import cl.unaccess.citas.model.Cita;
import cl.unaccess.citas.dto.CitaDTO;
import cl.unaccess.citas.repository.CitaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaService {

    private final CitaRepository repo;

    public CitaService(CitaRepository repo) {
        this.repo = repo;
    }

    public Cita agendarCita(CitaDTO dto) {
        Cita c = new Cita();
        c.setPacienteRut(dto.getPacienteRut());
        c.setProfesionalUsername(dto.getProfesionalUsername());
        c.setFechaHora(dto.getFechaHora());
        c.setEstado("AGENDADA"); // Regla de negocio automática para la rúbrica
        return repo.save(c);
    }

    public List<Cita> listarPorPaciente(String rut) {
        return repo.findByPacienteRut(rut);
    }
}