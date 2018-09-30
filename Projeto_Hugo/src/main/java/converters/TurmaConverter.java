package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.TurmaDAO;
import entity.Turma;


@FacesConverter(forClass=Turma.class)
public class TurmaConverter implements Converter{

	@Inject
	private TurmaDAO turmaDAO;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		return turmaDAO.getByID(Long.parseLong(id));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object entidade) {
		return entidade.toString();
	}

	
	
}


