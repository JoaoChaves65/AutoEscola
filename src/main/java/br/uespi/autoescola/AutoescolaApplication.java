package br.uespi.autoescola;

import br.uespi.autoescola.model.Aluno;
import br.uespi.autoescola.model.Aula;
import br.uespi.autoescola.model.Instrutor;
import br.uespi.autoescola.model.Veiculo;
import br.uespi.autoescola.repository.AlunoRepository;
import br.uespi.autoescola.repository.AulaRepository;
import br.uespi.autoescola.repository.InstrutorRepository;
import br.uespi.autoescola.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class AutoescolaApplication implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AulaRepository aulasRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public static void main(String[] args) {
        SpringApplication.run(AutoescolaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Inserir dados no banco de dados
        Aluno aluno = new Aluno();
        aluno.setNome("João Silva");
        aluno.setCpf("123.456.789-00");
        aluno.setDataDeNascimento(new Date());
        aluno.setTelefone("99999-9999");
        alunoRepository.save(aluno);

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Pedro Silva");
        aluno1.setCpf("000.000.000-00");
        aluno1.setDataDeNascimento(new Date(13/12/2000));
        aluno1.setTelefone("00000-0000");
        alunoRepository.save(aluno1);

        Instrutor instrutor = new Instrutor();
        instrutor.setNome("Maria Souza");
        instrutor.setCpf("987.654.321-00");
        instrutor.setDataDeNascimento(new Date());
        instrutor.setTelefone("88888-8888");
        instrutorRepository.save(instrutor);

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC-1234");
        veiculo.setModelo("Fusca");
        veiculo.setAno(1970);
        veiculoRepository.save(veiculo);

        Aula aula = new Aula();
        aula.setData(new Date());
        aula.setHora("10:00");
        aula.setLocal("Sala 1");

        aula.setAlunos(new HashSet<>());
        aula.getAlunos().add(aluno);
        aula.getAlunos().add(aluno1);

        aula.setInstrutores(new HashSet<>());
        aula.getInstrutores().add(instrutor);

        aula.setVeiculos(new HashSet<>());
        aula.getVeiculos().add(veiculo);

        aulasRepository.save(aula);
    }
}
