package service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.TurmaDAO;
import entity.Turma;
import util.TransacionalCdi;

@ApplicationScoped
public class TurmaService implements Serializable, Service<Turma> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7694195274556052590L;
	@Inject
	private TurmaDAO turmaDAO;
	
	@Override
	@TransacionalCdi
	public void save(Turma turma) {
		turmaDAO.save(turma);
	}

	@Override
	@TransacionalCdi
	public void update(Turma turma)  {
			turmaDAO.update(turma);
	}

	@Override
	@TransacionalCdi
	public void remove(Turma turma) {
		turmaDAO.remove(turma);
	}

	@Override
	public Turma getByID(long turmaId)  {
			return turmaDAO.getByID(turmaId);
	}

	/* (non-Javadoc)
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#getAll()
	 */
	@Override
	public List<Turma> getAll() {
			return turmaDAO.getAll();
	}
		
}

