package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Medico; 
import com.example.demo.model.Paciente; 
import com.example.demo.service.MedicoService; 

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> listarTodos() {
        List<Medico> medicos = medicoService.listarTodos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
        Medico medico = medicoService.buscarPorId(id);
        return new ResponseEntity<>(medico, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarMedico(@RequestBody Medico medico) {
        medicoService.salvarMedico(medico);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Exemplo de método personalizado para buscar por especialidade
    @GetMapping("/especialidade/{especialidade}")
    public ResponseEntity<List<Medico>> buscarPorEspecialidade(@PathVariable String especialidade) {
        List<Medico> medicos = medicoService.buscarPorEspecialidade(especialidade);
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    // Exemplo de método personalizado para buscar pacientes de um médico
    @GetMapping("/pacientes-do-medico/{medicoId}")
    public ResponseEntity<List<Paciente>> buscarPacientesDoMedico(@PathVariable Long medicoId) {
        List<Paciente> pacientes = medicoService.buscarPacientesDoMedico(medicoId);
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
}
