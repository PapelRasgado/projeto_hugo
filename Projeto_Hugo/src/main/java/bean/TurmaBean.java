package bean;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Turma;
import service.AlunoService;
import service.TurmaService;

@ViewScoped
@Named
public class TurmaBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3258793309562850249L;

	@Inject
	private TurmaService service;
	
	@Inject
	private AlunoService serviceAluno;
	
	protected List<Long> alunos;

	protected Turma entidade;

	protected Collection<Turma> entidades;

	public TurmaBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Turma entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Turma getEntidade() {
		return entidade;
	}

	public void setEntidade(Turma entidade) {
		this.entidade = entidade;
	}

	public Collection<Turma> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Turma> entidades) {
		this.entidades = entidades;
	}

	public void save() {
		for (Long id : alunos) {
			entidade.addAluno(getServiceAluno().getByID(id));
		}
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

	protected Turma newEntidade() {
		return new Turma();
	}

	public TurmaService getService() {
		return service;
	}
	
	public AlunoService getServiceAluno() {
		return serviceAluno;
	}
	
	public List<Long> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<Long> alunos) {
		this.alunos = alunos;
	}

}