package service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.DisciplinaDAO;
import entity.Disciplina;
import util.TransacionalCdi;

@ApplicationScoped
public class DisciplinaService implements Serializable, Service<Disciplina> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7694195274556052590L;
	@Inject
	private DisciplinaDAO disciplinaDAO;
	
	@Override
	@TransacionalCdi
	public void save(Disciplina disciplina) {
		disciplinaDAO.save(disciplina);
	}

	@Override
	@TransacionalCdi
	public void update(Disciplina disciplina)  {
			disciplinaDAO.update(disciplina);
	}

	@Override
	@TransacionalCdi
	public void remove(Disciplina disciplina) {
		disciplinaDAO.remove(disciplina);
	}

	@Override
	public Disciplina getByID(long disciplinaId)  {
			return disciplinaDAO.getByID(disciplinaId);
	}

	/* (non-Javadoc)
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#getAll()
	 */
	@Override
	public List<Disciplina> getAll() {
			return disciplinaDAO.getAll();
	}
		
}

