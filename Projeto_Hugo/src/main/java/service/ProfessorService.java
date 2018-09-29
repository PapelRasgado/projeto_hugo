package service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.ProfessorDAO;
import entity.Professor;
import util.TransacionalCdi;

@ApplicationScoped
public class ProfessorService implements Serializable, Service<Professor> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5942808688229031947L;
	@Inject
	private ProfessorDAO professorDAO;
	
	@Override
	@TransacionalCdi
	public void save(Professor professor) {
		professorDAO.save(professor);
	}

	@Override
	@TransacionalCdi
	public void update(Professor professor)  {
			professorDAO.update(professor);
	}

	@Override
	@TransacionalCdi
	public void remove(Professor professor) {
		professorDAO.remove(professor);
	}

	@Override
	public Professor getByID(long professorId)  {
			return professorDAO.getByID(professorId);
	}

	/* (non-Javadoc)
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#getAll()
	 */
	@Override
	public List<Professor> getAll() {
			return professorDAO.getAll();
	}
		
}

