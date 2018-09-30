package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.DisciplinaDAO;
import entity.Disciplina;


@FacesConverter(forClass=Disciplina.class)
public class DisciplinaConverter implements Converter{

	@Inject
	private DisciplinaDAO disciplinaDAO;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		return disciplinaDAO.getByID(Long.parseLong(id));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object entidade) {
		return entidade.toString();
	}

	
	
}


