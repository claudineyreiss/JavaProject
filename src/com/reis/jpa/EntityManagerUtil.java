package com.reis.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.collections.Factory;

public class EntityManagerUtil {
	
	private static EntityManagerFactory factory = null;
	private static EntityManager em = null;
	
	public static EntityManager getEntityManager(){
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("ProjetoJSF");
		}
		
		if (em == null){
			em = factory.createEntityManager();
		}
		
		return em;
	}
}
