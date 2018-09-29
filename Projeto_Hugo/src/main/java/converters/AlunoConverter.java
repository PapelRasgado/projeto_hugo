package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.AlunoDAO;
import entity.Aluno;


@FacesConverter(forClass=Aluno.class)
public class AlunoConverter implements Converter{

	@Inject
	private AlunoDAO alunoDAO;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		return alunoDAO.getByID(Long.parseLong(id));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object entidade) {
		return entidade.toString();
	}

	
	
}


