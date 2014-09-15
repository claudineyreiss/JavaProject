package com.reis.testes;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import com.reis.beans.Funcionario;
import com.reis.beans.Projeto;
import com.reis.beans.ProjetoFuncionario;
import com.reis.beans.Setor;
import com.reis.jpa.EntityManagerUtil;

public class TesteInserirProjeto {

	public static void main(String[]args){
		EntityManager em = EntityManagerUtil.getEntityManager();
		Setor setor = em.find(Setor.class, 1);
		Funcionario func = em.find(Funcionario.class, 1);
		Projeto projeto = new Projeto();
		
		projeto.setAtivo(true);
		projeto.setDescricao("Meu novo projeto com JSF");
		projeto.setFim(new Date());
		projeto.setInicio(new Date());
		projeto.setNome("Sistema de funcionarios");
		projeto.setSetor(setor);
		
		ProjetoFuncionario pf = new ProjetoFuncionario();
		pf.setCargaHoraria(100);
		pf.setFimParticipacao(new Date());
		pf.setFuncionario(func);
		pf.setGestor(true);
		pf.setInicioParticipacao(new Date());
		
		projeto.adicionarFuncionario(pf);
		em.getTransaction().begin();
		em.persist(projeto);
		em.getTransaction().commit();
		
		System.out.println("Projeto Inserido com sucesso!");
	}
}
