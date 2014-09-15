package com.reis.testes;

import javax.persistence.EntityManager;

import com.reis.beans.Grupo;
import com.reis.jpa.EntityManagerUtil;

public class TesteInserirGrupo {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		Grupo g = new Grupo();
		g.setNome("Gestores");
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		
	}

}
