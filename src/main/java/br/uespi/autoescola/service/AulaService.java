package br.uespi.autoescola.service;

import br.uespi.autoescola.model.Aula;
import br.uespi.autoescola.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    public List<Aula> findAll() {
        return aulaRepository.findAll();
    }

    public Aula findById(Long id) {
        return aulaRepository.findById(id).orElse(null);
    }

    public Aula save(Aula aula) {
        return aulaRepository.save(aula);
    }

    public void deleteById(Long id) {
        aulaRepository.deleteById(id);
    }
}
