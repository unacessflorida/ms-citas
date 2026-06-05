package cl.unaccess.citas.controller;

import cl.unaccess.citas.model.Cita;
import cl.unaccess.citas.dto.CitaDTO;
import cl.unaccess.citas.service.CitaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/v1/citas")
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    
    @PostMapping
    public ResponseEntity<Cita> crear(@RequestBody CitaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.agendarCita(dto));
    }

   
    @GetMapping("/paciente/{rut}")
    public ResponseEntity<List<Cita>> listarPorPaciente(@PathVariable String rut) {
        return ResponseEntity.ok(service.listarPorPaciente(rut));
    }
}