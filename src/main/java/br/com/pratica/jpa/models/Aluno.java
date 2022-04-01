package br.com.pratica.jpa.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Embedded
    private AlunoDadosPessoal alunoDadosPessoal;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<CursoRegistro> cursosAtivos = new ArrayList<>();

    // Construtores
    public Aluno() {
    }

    public Aluno(String nome, String cpf, String rg) {
        this.nome = nome;
        this.alunoDadosPessoal = new AlunoDadosPessoal(cpf, rg);
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

    public String getCpf() {
        return this.alunoDadosPessoal.getCpf();
    }

    public void setCpf(String cpf) {
        this.alunoDadosPessoal.setCpf(cpf);
    }
    
    public String getRg() {
    	return this.alunoDadosPessoal.getRg();
    }
    
    public void setRg(String rg) {
    	this.alunoDadosPessoal.setRg(rg);
    }

    public List<CursoRegistro> getCursosAtivos() {
        return cursosAtivos;
    }

    public void setCursosAtivos(List<CursoRegistro> cursosAtivos) {
        this.cursosAtivos = cursosAtivos;
    }

	public AlunoDadosPessoal getAlunoDadosPessoal() {
		return alunoDadosPessoal;
	}

	public void setAlunoDadosPessoal(AlunoDadosPessoal alunoDadosPessoal) {
		this.alunoDadosPessoal = alunoDadosPessoal;
	}

}
