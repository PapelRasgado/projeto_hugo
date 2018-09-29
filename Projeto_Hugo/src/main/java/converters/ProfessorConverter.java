package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.ProfessorDAO;
import entity.Professor;


@FacesConverter(forClass=Professor.class)
public class ProfessorConverter implements Converter{

	@Inject
	private ProfessorDAO professorDAO;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		return professorDAO.getByID(Long.parseLong(id));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object entidade) {
		return entidade.toString();
	}

	
	
}


