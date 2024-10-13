package br.uespi.autoescola.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private Date dataDeNascimento;
    private String telefone;

}
