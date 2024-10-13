package br.uespi.autoescola.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String telefone;
    private String cpf;
    private String nome;
    private Date dataDeNascimento;

}
