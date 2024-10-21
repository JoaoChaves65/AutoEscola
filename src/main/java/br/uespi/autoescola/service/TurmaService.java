package br.uespi.autoescola.service;

import br.uespi.autoescola.model.Turma;
import br.uespi.autoescola.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Turma findById(Long codigoTurma) {
        return turmaRepository.findById(codigoTurma).orElse(null);
    }

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void deleteById(Long codigoTurma) {
        turmaRepository.deleteById(codigoTurma);
    }

    public Turma update(Long codigoTurma, Turma turma) {
        if (turmaRepository.existsById(codigoTurma)) {
            turma.setCodigoTurma(codigoTurma);
            return turmaRepository.save(turma);
        } else {
            return null;
        }
    }
}
