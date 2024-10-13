package br.uespi.autoescola.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String modelo;
    private Integer ano;

    @ManyToMany
    @JoinTable(
        name = "Veiculo_Aula",
        joinColumns = @JoinColumn(name = "fk_Veiculo_ID"),
        inverseJoinColumns = @JoinColumn(name = "fk_Aula_ID")
    )
    private Set<Aula> aula;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Set<Aula> getAula() {
        return aula;
    }

    public void setAula(Set<Aula> aula) {
        this.aula = aula;
    }
}

