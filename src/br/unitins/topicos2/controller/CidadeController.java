package br.unitins.topicos2.controller;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.unitins.topicos2.model.Cidade;

@Named
@ViewScoped
public class CidadeController extends Controller<Cidade>  {

	private static final long serialVersionUID = 4689020451003580454L;

	public void limpar() {
		setEntity(null);
	}

	@Override
	public Cidade getEntity() {
		if (entity == null)
			entity = new Cidade();
		return entity;
	}
	
	public void abrirListagemCidade() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true); // nao permite redimencionar
        options.put("draggable", false); // nao permite arrastar
        options.put("modal", true); // abrir como modal
        PrimeFaces.current().dialog().openDynamic("listagemcidade", options, null);
    }
     
    public void cidadeSelecionada(SelectEvent event) {
        Cidade cidade = (Cidade) event.getObject();
        setEntity(cidade);
    }
	
}