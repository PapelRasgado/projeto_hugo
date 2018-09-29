package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Disciplina implements Identificavel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina_seq_gen")
	@SequenceGenerator(name = "disciplina_seq_gen", sequenceName = "disciplina_id_seq")
	@Column(name = "id_disciplina")
	private Long id;

	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_professor")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name="id_turma")
	private Turma turma;

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

	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Turma getTurma() {
		return turma;
	}
	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Disciplina(String nome, Professor professor, Turma turma) {
		super();
		this.nome = nome;
		this.professor = professor;
		this.turma = turma;
	}

	public Disciplina() {

	}

}
