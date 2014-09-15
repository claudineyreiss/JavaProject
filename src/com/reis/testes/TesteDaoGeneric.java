package com.reis.testes;

import java.util.List;

import com.reis.beans.Setor;
import com.reis.modelo.DAOSetor;

public class TesteDaoGeneric {

	public static void main(String[] args) {
		DAOSetor<Setor> dao = new DAOSetor<Setor>();
		List<Setor> lista = dao.listar();
		
		for(Setor o: lista){
			System.out.println("Codigo:" + o.getId() + " Nome: " + o.getNome());
		}
		
	}

}
