package dao;

import java.util.List;

import entity.Turma;
import filtros.TurmaFiltro;

public class TurmaDAO extends DAO<Turma> {
	
	public TurmaDAO() {
		super(Turma.class);
	}

	public List<Turma> findBy(TurmaFiltro filtro) {
		return null;
	}
	
}