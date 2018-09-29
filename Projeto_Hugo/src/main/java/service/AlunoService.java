package service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.AlunoDAO;
import entity.Aluno;
import util.TransacionalCdi;

@ApplicationScoped
public class AlunoService implements Serializable, Service<Aluno> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7930633216172781845L;
	
	@Inject
	private AlunoDAO alunoDAO;
	
	@Override
	@TransacionalCdi
	public void save(Aluno aluno) {
		alunoDAO.save(aluno);
	}

	@Override
	@TransacionalCdi
	public void update(Aluno aluno)  {
			alunoDAO.update(aluno);
	}

	@Override
	@TransacionalCdi
	public void remove(Aluno aluno) {
		alunoDAO.remove(aluno);
	}

	@Override
	public Aluno getByID(long alunoId)  {
			return alunoDAO.getByID(alunoId);
	}

	/* (non-Javadoc)
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#getAll()
	 */
	@Override
	public List<Aluno> getAll() {
			return alunoDAO.getAll();
	}
		
}

