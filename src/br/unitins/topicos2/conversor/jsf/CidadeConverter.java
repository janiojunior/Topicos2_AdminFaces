package br.unitins.topicos2.conversor.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unitins.topicos2.factory.JPAFactory;
import br.unitins.topicos2.model.Cidade;
import br.unitins.topicos2.repository.CidadeRepository;

// com essa anotacao, este conversor precisa adicionar na interface
//@FacesConverter("cidadeConverter")

// conversor padrao - nao precisa de adicionar na interface
@FacesConverter(forClass=Cidade.class)
public class CidadeConverter implements Converter<Cidade>{

	@Override
	public Cidade getAsObject(FacesContext context, 
			UIComponent component, 
			String value) {
		if (value != null && !value.trim().isEmpty()) {
			CidadeRepository repo = new CidadeRepository(JPAFactory.getEntityManager());
			Cidade c = repo.find(Integer.parseInt(value), Cidade.class);
			return c;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Cidade value) {
		if (value != null && value.getId() != null) {
			return value.getId().toString();
		}
		return null;
	}

}
