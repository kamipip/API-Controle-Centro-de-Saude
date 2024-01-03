package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Paciente; 
import com.example.demo.repository.PacienteRepository; 

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente cadastrarPaciente(Paciente paciente) {
        if (cpfJaCadastrado(paciente.getCpf())) {
            return null;
        }
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizarPaciente(Long id, Paciente pacienteAtualizado) {
        Paciente pacienteExistente = pacienteRepository.findById(id).orElse(null);

        if (pacienteExistente != null) {
            // Atualize os atributos relevantes do pacienteExistente com os valores de pacienteAtualizado
            pacienteExistente.setNome(pacienteAtualizado.getNome());
            pacienteExistente.setCpf(pacienteAtualizado.getCpf());
            pacienteExistente.setHistoricoMedico(pacienteAtualizado.getHistoricoMedico());

            return pacienteRepository.save(pacienteExistente);
        }

        return null; 
    }

    public void removerPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    private boolean cpfJaCadastrado(String cpf) {
        return pacienteRepository.existsByCpf(cpf);
    }
}
