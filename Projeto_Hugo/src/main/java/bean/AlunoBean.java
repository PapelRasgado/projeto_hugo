package bean;
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Aluno;
import service.AlunoService;

@ViewScoped
@Named
public class AlunoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4835436883993207269L;

	@Inject
	private AlunoService service;

	protected Aluno entidade;

	protected Collection<Aluno> entidades;

	public AlunoBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Aluno entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Aluno getEntidade() {
		return entidade;
	}

	public void setEntidade(Aluno entidade) {
		this.entidade = entidade;
	}

	public Collection<Aluno> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Aluno> entidades) {
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

	protected Aluno newEntidade() {
		return new Aluno();
	}

	public AlunoService getService() {
		return service;
	}

}