package br.uespi.autoescola;

import br.uespi.autoescola.model.Aluno;
import br.uespi.autoescola.model.Aula;
import br.uespi.autoescola.model.Instrutor;
import br.uespi.autoescola.model.Veiculo;
import br.uespi.autoescola.service.AlunoService;
import br.uespi.autoescola.service.AulaService;
import br.uespi.autoescola.service.InstrutorService;
import br.uespi.autoescola.service.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List; 

@SpringBootApplication
public class AutoescolaApplication implements CommandLineRunner {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AulaService aulaService;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private VeiculoService veiculoService;

    public static void main(String[] args) {
        SpringApplication.run(AutoescolaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Aluno aluno = new Aluno();
        aluno.setNome("João Silva");
        aluno.setCpf("123.456.789-00");
        aluno.setDataDeNascimento(LocalDate.of(1970,06,27));
        aluno.setTelefone("99999-9999");
        alunoService.save(aluno);

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Pedro Silva");
        aluno1.setCpf("000.000.000-00");
        aluno1.setDataDeNascimento(LocalDate.of(2000, 12, 13));
        aluno1.setTelefone("00000-0000");
        alunoService.save(aluno1);

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Luiz Santos");
        aluno2.setCpf("222.222.222-22");
        aluno2.setDataDeNascimento(LocalDate.of(1998, 01, 20));
        aluno2.setTelefone("22222-2222");
        alunoService.save(aluno2);

        Instrutor instrutor = new Instrutor();
        instrutor.setNome("Maria Souza");
        instrutor.setCpf("987.654.321-00");
        instrutor.setDataDeNascimento(new Date());
        instrutor.setTelefone("88888-8888");
        instrutorService.save(instrutor);

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC-1234");
        veiculo.setModelo("Fusca");
        veiculo.setAno(1970);
        veiculoService.save(veiculo);

        Aula aula = new Aula();
        aula.setData(new Date());
        aula.setHora("10:00");
        aula.setLocal("Sala 1");

        Aluno alunoAtualizado = new Aluno();
        alunoAtualizado.setNome("João Silva Atualizado");
        alunoAtualizado.setCpf("123.456.789-00");
        alunoAtualizado.setDataDeNascimento(LocalDate.of(1933, 12, 13));
        alunoAtualizado.setTelefone("99999-9999");
        alunoService.update(aluno.getId(), alunoAtualizado);

        aula.setAlunos(new HashSet<>());
        aula.getAlunos().add(aluno);
        aula.getAlunos().add(aluno1);
        aula.getAlunos().add(aluno2);

        aula.setInstrutores(new HashSet<>());
        aula.getInstrutores().add(instrutor);

        aula.setVeiculos(new HashSet<>());
        aula.getVeiculos().add(veiculo);

        aulaService.save(aula);

        List<Aluno> alunos = alunoService.findAll();
        alunos.forEach(a -> System.out.println(a.getNome()));

        Aluno alunoEncontrado = alunoService.findById(aluno.getId());
        if (alunoEncontrado != null) {
            System.out.println("Aluno encontrado: " + alunoEncontrado.getNome());
        }

        alunoService.deleteById(aluno1.getId());
        System.out.println("Aluno com ID " + aluno1.getId() + " deletado.");
    }
}
