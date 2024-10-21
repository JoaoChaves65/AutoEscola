package br.uespi.autoescola.service;

import br.uespi.autoescola.model.Prova;
import br.uespi.autoescola.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvaService {

    @Autowired
    private ProvaRepository provaRepository;

    public List<Prova> findAll() {
        return provaRepository.findAll();
    }

    public Prova findById(Long codigoProva) {
        return provaRepository.findById(codigoProva).orElse(null);
    }

    public Prova save(Prova prova) {
        return provaRepository.save(prova);
    }

    public void deleteById(Long codigoProva) {
        provaRepository.deleteById(codigoProva);
    }

    public Prova update(Long codigoProva, Prova prova) {
        if (provaRepository.existsById(codigoProva)) {
            prova.setCodigoProva(codigoProva);
            return provaRepository.save(prova);
        } else {
            return null;
        }
    }
}
