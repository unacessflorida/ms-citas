package cl.unaccess.citas.service;

import cl.unaccess.citas.model.Cita;
import cl.unaccess.citas.dto.CitaDTO;
import cl.unaccess.citas.repository.CitaRepository;
import cl.unaccess.citas.client.PacienteClient;
import cl.unaccess.citas.client.UsuarioClient;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaService {

    private final CitaRepository repo;
    private final PacienteClient pacienteClient;
    private final UsuarioClient usuarioClient;

    public CitaService(CitaRepository repo, PacienteClient pacienteClient, UsuarioClient usuarioClient) {
        this.repo = repo;
        this.pacienteClient = pacienteClient;
        this.usuarioClient = usuarioClient;
    }

    public Cita agendarCita(CitaDTO dto) {
        if (!pacienteClient.existePaciente(dto.getPacienteRut())) {
            throw new RuntimeException("El paciente con RUT " + dto.getPacienteRut() + " no existe");
        }
        if (!usuarioClient.existeProfesional(dto.getProfesionalUsername())) {
            throw new RuntimeException("El profesional " + dto.getProfesionalUsername() + " no existe");
        }

        Cita c = new Cita();
        c.setPacienteRut(dto.getPacienteRut());
        c.setProfesionalUsername(dto.getProfesionalUsername());
        c.setFechaHora(dto.getFechaHora());
        c.setEstado("AGENDADA");
        return repo.save(c);
    }

    public List<Cita> listarPorPaciente(String rut) {
        return repo.findByPacienteRut(rut);
    }
}