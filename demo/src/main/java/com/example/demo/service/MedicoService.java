package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Medico;
import com.example.demo.model.Paciente;
import com.example.demo.repository.MedicoRepository;
import com.example.demo.repository.PacienteRepository;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository; 

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public void salvarMedico(Medico medico) {
        medicoRepository.save(medico);
    }

    public void deletarMedico(Long id) {
        medicoRepository.deleteById(id);
    }

    // Método personalizado para buscar por especialidade
    public List<Medico> buscarPorEspecialidade(String especialidade) {
        return medicoRepository.findByEspecialidadeIgnoreCase(especialidade);
    }

    // Método personalizado para buscar pacientes de um médico
    public List<Paciente> buscarPacientesDoMedico(Long medicoId) {
        return pacienteRepository.findByConsultas_Medico_Id(medicoId);
    }
}
