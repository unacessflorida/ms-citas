package cl.unaccess.citas.repository;

import cl.unaccess.citas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByPacienteRut(String pacienteRut);
}