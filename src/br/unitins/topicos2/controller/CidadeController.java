package br.unitins.topicos2.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.unitins.topicos2.model.Cidade;
import br.unitins.topicos2.validation.CidadeValidation;

@Named
@ViewScoped
@RolesAllowed("ADMINISTRADOR")
public class CidadeController extends Controller<Cidade>  {

	public CidadeController() {
		super(new CidadeValidation());
	}

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
        options.put("resizable", false); // nao permite redimencionar
        options.put("draggable", false); // nao permite arrastar
        options.put("modal", true); // abrir como modal
        options.put("width", "80%");
        options.put("height", "500");
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        PrimeFaces.current().dialog().openDynamic("listagemcidade", options, null);
    }
     
    public void cidadeSelecionada(SelectEvent event) {
        Cidade cidade = (Cidade) event.getObject();
        setEntity(cidade);
    }
	
}
