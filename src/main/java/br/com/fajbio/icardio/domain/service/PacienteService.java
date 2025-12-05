package br.com.fajbio.icardio.domain.service;

import br.com.fajbio.icardio.domain.model.Paciente;
import br.com.fajbio.icardio.domain.model.Unidade;
import br.com.fajbio.icardio.domain.model.Usuario;
import br.com.fajbio.icardio.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteRepository repository;

    public List<Paciente> encontrarPelaUnidade(Unidade unidade) {
        return repository.findByUnidade(unidade);
    }

    @Transactional
    public Paciente criarPaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> encontrarTodos() {
        return repository.findAll();
    }

    public List<Paciente> encontrarPelaUnidadeEUsuario(Unidade uni, Usuario usr) {
        return repository.findByUnidadeAndUsuario(uni,usr);
    }
}
