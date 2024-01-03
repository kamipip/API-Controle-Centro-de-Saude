package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Consulta;
import com.example.demo.repository.ConsultaRepository;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> listarTodas() {
        return consultaRepository.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public void salvarConsulta(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    public void deletarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    public List<Consulta> buscarConsultasDoPaciente(Long pacienteId) {
        return consultaRepository.findByPaciente_Id(pacienteId);
    }

    public List<Consulta> buscarConsultasDoMedico(Long medicoId) {
        return consultaRepository.findByMedico_Id(medicoId);
    }
}
