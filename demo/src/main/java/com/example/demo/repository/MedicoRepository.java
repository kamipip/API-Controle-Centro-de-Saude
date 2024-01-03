package com.example.demo.repository;

import com.example.demo.model.Medico;  
import com.example.demo.model.Paciente;  
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findByEspecialidadeIgnoreCase(String especialidade);

    List<Paciente> findByConsultas_Medico_Id(Long medicoId);
}
