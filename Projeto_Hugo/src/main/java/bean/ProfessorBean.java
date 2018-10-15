package bean;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Professor;
import service.ProfessorService;

@ViewScoped
@Named
public class ProfessorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8167986307320694213L;

	@Inject
	private ProfessorService service;

	protected Professor entidade;
	
	protected String senha;

	protected Collection<Professor> entidades;

	public ProfessorBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Professor entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Professor getEntidade() {
		return entidade;
	}

	public void setEntidade(Professor entidade) {
		this.entidade = entidade;
	}

	public Collection<Professor> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Professor> entidades) {
		this.entidades = entidades;
	}

	public void save(){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			entidade.setHashSenha(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
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

	protected Professor newEntidade() {
		return new Professor();
	}

	public ProfessorService getService() {
		return service;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}