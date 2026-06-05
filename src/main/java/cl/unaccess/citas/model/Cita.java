package cl.unaccess.citas.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pacienteRut;
    private String profesionalUsername; // Quién lo atiende (ej: matrona.marta)
    private LocalDateTime fechaHora;     // Fecha y hora del control
    private String estado;               // Ej: AGENDADA, CONFIRMADA, REALIZADA

    public Cita() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPacienteRut() { return pacienteRut; }
    public void setPacienteRut(String pacienteRut) { this.pacienteRut = pacienteRut; }

    public String getProfesionalUsername() { return profesionalUsername; }
    public void setProfesionalUsername(String profesionalUsername) { this.profesionalUsername = profesionalUsername; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}