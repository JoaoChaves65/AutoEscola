package br.uespi.autoescola.service;

import br.uespi.autoescola.model.Instrutor;
import br.uespi.autoescola.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public List<Instrutor> findAll() {
        return instrutorRepository.findAll();
    }

    public Instrutor findById(Long id) {
        return instrutorRepository.findById(id).orElse(null);
    }

    public Instrutor save(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public void deleteById(Long id) {
        instrutorRepository.deleteById(id);
    }

    public Instrutor update(Long id, Instrutor instrutor) {
        if (instrutorRepository.existsById(id)) {
            instrutor.setId(id);
            return instrutorRepository.save(instrutor);
        } else {
            return null;
        }
    }
}
