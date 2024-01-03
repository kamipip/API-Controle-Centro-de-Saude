package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Consulta; 
import com.example.demo.service.ConsultaService; 

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<Consulta>> listarTodas() {
        List<Consulta> consultas = consultaService.listarTodas();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarPorId(@PathVariable Long id) {
        Consulta consulta = consultaService.buscarPorId(id);
        return new ResponseEntity<>(consulta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> marcarConsulta(@RequestBody Consulta consulta) {
        consultaService.salvarConsulta(consulta);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Exemplo de método personalizado para buscar todas as consultas de um paciente
    @GetMapping("/do-paciente/{pacienteId}")
    public ResponseEntity<List<Consulta>> buscarConsultasDoPaciente(@PathVariable Long pacienteId) {
        List<Consulta> consultas = consultaService.buscarConsultasDoPaciente(pacienteId);
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    // Exemplo de método personalizado para buscar todas as consultas de um médico
    @GetMapping("/do-medico/{medicoId}")
    public ResponseEntity<List<Consulta>> buscarConsultasDoMedico(@PathVariable Long medicoId) {
        List<Consulta> consultas = consultaService.buscarConsultasDoMedico(medicoId);
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }
}
