package dao;

import java.util.List;

import entity.Aluno;
import filtros.AlunoFiltro;

public class AlunoDAO extends DAO<Aluno> {
	
	public AlunoDAO() {
		super(Aluno.class);
	}

	public List<Aluno> findBy(AlunoFiltro filtro) {
		return null;
	}
	
}