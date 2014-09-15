package com.reis.conversores;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.reis.beans.Setor;
import com.reis.jpa.EntityManagerUtil;

public class ConverterSetor implements Converter, Serializable {

	//converte da tela para o objeto
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string)
			throws ConverterException {
		if(string == null || string.equals("Selecione um setor")){
			return null;
		}
		return EntityManagerUtil.getEntityManager().find(Setor.class, Integer.parseInt(string));
	}

	//converte do objeto pra tela
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj)
			throws ConverterException {
		if(obj == null){
			return null;
		}
		Setor o = (Setor) obj;
		return o.getId().toString();
	}

}
