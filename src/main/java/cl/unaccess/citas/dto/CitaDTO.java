package cl.unaccess.citas.dto;

import java.time.LocalDateTime;

public class CitaDTO {
    private String pacienteRut;
    private String profesionalUsername;
    private LocalDateTime fechaHora;

    public CitaDTO() {}

    public String getPacienteRut() { return pacienteRut; }
    public void setPacienteRut(String pacienteRut) { this.pacienteRut = pacienteRut; }

    public String getProfesionalUsername() { return profesionalUsername; }
    public void setProfesionalUsername(String profesionalUsername) { this.profesionalUsername = profesionalUsername; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
}