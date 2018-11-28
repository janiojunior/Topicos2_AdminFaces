package br.unitins.topicos2.report;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public abstract String getArquivoJasper();

	public abstract HashMap<String, Class<?>> getParametros();

	public abstract EntityManager getEntityManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getServletContext().getRealPath("/reports/" + getArquivoJasper());

			EntityManager em = getEntityManager();
			em.getTransaction().begin();
			Connection connection = em.unwrap(Connection.class);

			// Adicionando os parametros
			Map<String, Object> parametros = new HashMap<String, Object>();
			HashMap<String, Class<?>> listaParametros = getParametros();
			for (String key : listaParametros.keySet()) {
				if (!request.getParameter(key).equals("null"))
					if (listaParametros.get(key).getName().equals("java.lang.Integer"))
						parametros.put(key, Integer.valueOf(request.getParameter(key)));
					else if (listaParametros.get(key).toString().contains("java.lang.String"))
						parametros.put(key, new String(request.getParameter(key)));
					else if (listaParametros.get(key).toString().contains("java.lang.Boolean"))
						parametros.put(key, Boolean.valueOf(request.getParameter(key)));
					else if (listaParametros.get(key).toString().contains("java.lang.Float"))
						parametros.put(key, Float.valueOf(request.getParameter(key)));
					else if (listaParametros.get(key).toString().contains("java.lang.Double"))
						parametros.put(key, Double.valueOf(request.getParameter(key)));

			}

			GeradorRelatorio gerador = new GeradorRelatorio(nome, parametros, connection);
			gerador.gerarPDFParaOutputStream(response.getOutputStream());

			em.getTransaction().commit();
			if (!connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}