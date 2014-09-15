package com.reis.testes;

import javax.persistence.EntityManager;

import com.reis.beans.Setor;
import com.reis.jpa.EntityManagerUtil;

public class TesteInserirSetor {
	
	public static void main(String[]args){
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		Setor s = new Setor();
		s.setNome("Administracao");
	
		Setor s2 = new Setor();
		s2.setNome("Operacional");
	
		em.getTransaction().begin();
		em.persist(s);
		em.persist(s2);
		em.getTransaction().commit();
		System.out.println("Sucesso na insercao");
	}
}
