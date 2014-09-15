package com.reis.conversores;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.reis.modelo.Ordem;

public class ConverterOrdem implements Serializable, Converter{

	private List<Ordem> listaOrdem;

	public ConverterOrdem(List<Ordem> listaOrdem) {
		super();
		this.listaOrdem = listaOrdem;
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string)
			throws ConverterException {
		
		Ordem retorno = null;
		for(Ordem o: listaOrdem){
			if(o.getAtributo().equals(string)){
				retorno = o;
			}
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj)
			throws ConverterException {
		if(obj == null){
			return null;
		}
		Ordem ordem = (Ordem) obj;
		return ordem.getAtributo().toString();
	}

	public List<Ordem> getListaOrdem() {
		return listaOrdem;
	}

	public void setListaOrdem(List<Ordem> listaOrdem) {
		this.listaOrdem = listaOrdem;
	}
	
}
