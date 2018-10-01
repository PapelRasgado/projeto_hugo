package bean;
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Disciplina;
import service.DisciplinaService;
import service.ProfessorService;
import service.TurmaService;

@ViewScoped
@Named
public class DisciplinaBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3258793309562850249L;

	@Inject
	private DisciplinaService service;
	
	@Inject
	private TurmaService turmaService;
	
	private Long idTurma;
	
	@Inject
	private ProfessorService professorService;
	
	private Long idProfessor;

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
		entidade.setProfessor(professorService.getByID(idProfessor));
		entidade.setTurma(turmaService.getByID(idTurma));
		getService().save(entidade);
		limpar();
	}

	public void editar(Long id) {
		this.getEntidade().setId(id);
		save();
	}

	public void limpar() {
		idProfessor = 0L;
		idTurma = 0L;
		entidades = getService().getAll();
		entidade = newEntidade();
	}

	protected Disciplina newEntidade() {
		return new Disciplina();
	}

	public DisciplinaService getService() {
		return service;
	}

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public TurmaService getTurmaService() {
		return turmaService;
	}

	public ProfessorService getProfessorService() {
		return professorService;
	}
	

}