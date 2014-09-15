package com.reis.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class UtilRelatorios {
	
	public static void imprimeRelatorio(String nomeRelatorio, HashMap parametros, List lista){
		try{
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
			String path = servletContext.getRealPath("/WEB-INF/relatorios/");
			//parametro jasper report
			parametros.put("SUBREPORT DIR", path + File.separator);
			JasperPrint jasperPrint = JasperFillManager.fillReport(servletContext.getRealPath("/WEB-INF/relatorios/") + File.separator + nomeRelatorio+ ".jasper", parametros, dataSource );
			byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);
			
			HttpServletResponse res = (HttpServletResponse) facesContext.getExternalContext().getResponse();
			res.setContentType("application/pdf");
			int codigo = (int) (Math.random() * 1000);
			res.setHeader("Content-disposition", "inline);filename-relatorio_" + codigo+".pdf");
			res.getOutputStream().write(b);
			facesContext.responseComplete();
			
		}catch(Exception e){
			UtilMensagens.mensagemErro("Erro ao imprimir: " + UtilErros.getMensagemErro(e));
			e.printStackTrace();
		}
	}
}
