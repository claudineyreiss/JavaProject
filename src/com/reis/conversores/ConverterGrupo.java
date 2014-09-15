package com.reis.conversores;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.reis.beans.Grupo;
import com.reis.jpa.EntityManagerUtil;

public class ConverterGrupo implements Converter, Serializable {

	//converte da tela para o objeto
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string)
			throws ConverterException {
		if(string == null || string.equals("Selecione um grupo")){
			return null;
		}
		return EntityManagerUtil.getEntityManager().find(Grupo.class, Integer.parseInt(string));
	}

	//converte do objeto pra tela
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj)
			throws ConverterException {
		if(obj == null){
			return null;
		}
		Grupo o = (Grupo) obj;
		return o.getId().toString();
	}

}
