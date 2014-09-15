package com.reis.testes;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import com.reis.beans.Funcionario;
import com.reis.beans.Grupo;
import com.reis.beans.Setor;
import com.reis.jpa.EntityManagerUtil;

public class TesteInserirFuncionario {
	
	public static void main(String[]args){
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		Grupo grupo = em.find(Grupo.class, 1);
		Setor setor = em.find(Setor.class, 1);
		Funcionario f = new Funcionario();
		
		f.setAtiva(true);
		f.setCpf("368.872.978-17");
		f.setEmail("rafael.reis777@yahoo.com.br");
		f.setGrupo(grupo);
		f.setNascimento(new Date());
		f.setNome("Rafael Reis");
		f.setNomeUsuario("rafael");
		f.setSalario(2000.00);
		f.setSenha("12345");
		f.setSetor(setor);
		
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		System.out.println("Inserido com sucesso!");
	}
}
