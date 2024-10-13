package br.uespi.autoescola.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private String hora;
    private String local;

}
