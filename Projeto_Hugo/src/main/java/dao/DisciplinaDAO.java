package dao;

import java.util.List;

import entity.Disciplina;
import filtros.DisciplinaFiltro;

public class DisciplinaDAO extends DAO<Disciplina> {
	
	public DisciplinaDAO() {
		super(Disciplina.class);
	}

	public List<Disciplina> findBy(DisciplinaFiltro filtro) {
		return null;
	}
	
}