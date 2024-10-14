package br.uespi.autoescola.service;

import br.uespi.autoescola.model.Veiculo;
import br.uespi.autoescola.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void deleteById(Long id) {
        veiculoRepository.deleteById(id);
    }

    public Veiculo update(Long id, Veiculo veiculo) {
        if (veiculoRepository.existsById(id)) {
            veiculo.setId(id);
            return veiculoRepository.save(veiculo);
        } else {
            return null;
        }
    }
}
