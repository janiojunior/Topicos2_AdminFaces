package br.unitins.topicos2.report;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;

import br.unitins.topicos2.factory.JPAFactory;

@WebServlet("/cidadeReport")
public class CidadeReportServlet extends ReportServlet {

	private static final long serialVersionUID = 1498447842163614442L;

	@Override
	public String getArquivoJasper() {
		return "CidadeReport2.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		param.put("NOME_CIDADE", String.class);
		return param;
	}

	@Override
	public EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

}
