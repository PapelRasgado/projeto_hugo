
package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Professor implements Identificavel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professor_seq_gen")
	@SequenceGenerator(name = "professor_seq_gen", sequenceName = "professor_id_seq")
	@Column(name = "id_professor")
	private Long id;

	private String nome;

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

	public Professor(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Professor() {

	}

}

