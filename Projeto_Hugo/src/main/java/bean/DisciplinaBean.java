package bean;
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Disciplina;
import service.AlunoService;
import service.DisciplinaService;

@ViewScoped
@Named
public class DisciplinaBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3258793309562850249L;

	@Inject
	private DisciplinaService service;
	
	private Long idTurma;

	protected Disciplina entidade;

	protected Collection<Disciplina> entidades;

	public DisciplinaBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Disciplina entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Disciplina getEntidade() {
		return entidade;
	}

	public void setEntidade(Disciplina entidade) {
		this.entidade = entidade;
	}

	public Collection<Disciplina> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Disciplina> entidades) {
		this.entidades = entidades;
	}

	public void save() {
		getService().save(entidade);
		limpar();
	}

	public void editar(Long id) {
		this.getEntidade().setId(id);
		save();
	}

	public void limpar() {
		entidades = getService().getAll();
		entidade = newEntidade();
	}

	protected Disciplina newEntidade() {
		return new Disciplina();
	}

	public DisciplinaService getService() {
		return service;
	}
	
//	public List<Long> getAlunos() {
//		return alunos;
//	}
//	
//	public void setAlunos(List<Long> alunos) {
//		this.alunos = alunos;
//	}

}