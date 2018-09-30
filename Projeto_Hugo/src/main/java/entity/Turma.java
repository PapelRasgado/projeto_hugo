
package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Turma implements Identificavel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turma_seq_gen")
	@SequenceGenerator(name = "turma_seq_gen", sequenceName = "turma_id_seq")
	@Column(name = "id_turma")
	private Long id;

	private String nome;
	
	@ManyToMany
	@JoinColumn(name="id_aluno")
	private Set<Aluno> alunos;
	
	@OneToMany
	@JoinColumn(name="id_disciplina")
	private Set<Disciplina> disciplinas;

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

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public void addDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}

	public Turma(String nome) {
		super();
		this.nome = nome;
	}
	
	public Turma(String nome, Set<Aluno> alunos, Set<Disciplina> disciplinas) {
		super();
		this.nome = nome;
		this.alunos = alunos;
		this.disciplinas = disciplinas;
	}

	public Turma() {
		alunos =  new HashSet<>();
		disciplinas = new HashSet<>();
	}

}

