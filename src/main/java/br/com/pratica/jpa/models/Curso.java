package br.com.pratica.jpa.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<CursoRegistro> alunosRegistrados = new ArrayList<>();

    // Construtores
    public Curso() {
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CursoRegistro> getAlunosRegistrados() {
        return alunosRegistrados;
    }

    public void setAlunosRegistrados(List<CursoRegistro> alunosRegistrados) {
        this.alunosRegistrados = alunosRegistrados;
    }

}
