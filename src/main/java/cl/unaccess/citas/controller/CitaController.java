package cl.unaccess.citas.controller;

import cl.unaccess.citas.model.Cita;
import cl.unaccess.citas.dto.CitaDTO;
import cl.unaccess.citas.service.CitaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/v1/citas")
@Tag(name = "Citas", description = "Gestion de citas medicas")
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    @Operation(summary = "Agendar una nueva cita medica (valida paciente y profesional)")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Cita agendada",
            content = @Content(examples = @ExampleObject(value = "{\"pacienteRut\":\"12345678-9\",\"profesionalUsername\":\"dr.perez\",\"fechaHora\":\"2026-07-10T10:00:00\"}"))),
        @ApiResponse(responseCode = "500", description = "Paciente o profesional no existe")
    })
    @PostMapping
    public ResponseEntity<Cita> crear(@RequestBody CitaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.agendarCita(dto));
    }

    @Operation(summary = "Listar citas de un paciente por su RUT")
    @ApiResponse(responseCode = "200", description = "Lista de citas del paciente")
    @GetMapping("/paciente/{rut}")
    public ResponseEntity<List<Cita>> listarPorPaciente(@PathVariable String rut) {
        return ResponseEntity.ok(service.listarPorPaciente(rut));
    }
}