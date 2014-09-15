package com.reis.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.reis.beans.Funcionario;
import com.reis.beans.Grupo;
import com.reis.jpa.EntityManagerUtil;
import com.reis.util.UtilErros;
import com.reis.util.UtilMensagens;

public class FuncionarioDAO {
	
	private EntityManager em;
	
	public FuncionarioDAO(){
		em = EntityManagerUtil.getEntityManager();
	}
	
	public List<Funcionario> listarTodos(){
		return em.createQuery("from Funcionario order by nome").getResultList();
	}

	public boolean gravar(Funcionario obj){
		try {
			em.getTransaction().begin();
			if (obj.getId() == null){
				em.persist(obj);
			} else {
				em.merge(obj);
			}
			em.getTransaction().commit();
			UtilMensagens.mensagemInformacao("Objeto persistido com sucesso!");
			return true;
		} catch (Exception e){
			if (em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMensagens.mensagemErro("Erro ao persistir objeto: "+
			                                  UtilErros.getMensagemErro(e));
			return false;
		}
	}
	
	public boolean excluir(Funcionario obj){
		try {
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			UtilMensagens.mensagemInformacao("Objeto removido com sucesso!");
			return true;
		} catch (Exception e){
			if (em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMensagens.mensagemErro("Erro ao remover objeto: "+
			                                  UtilErros.getMensagemErro(e));
			return false;
		}
	}	
	
	public boolean login(String usuario, String senha){
		Query query = em.createQuery("from Funcionario where upper(nomeUsuario) = :usuario"+ " and upper(senha) = :senha and ativo = true");
		query.setParameter("usuario", usuario.toUpperCase());
		query.setParameter("senha", senha.toUpperCase());
		
		if(!query.getResultList().isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	public Funcionario localizaPorNome(String usuario){
		return (Funcionario) em.createQuery("from Funcionario where upper(nomeUsuario) = " + ":usuario").setParameter("usuario", usuario.toUpperCase()).getSingleResult();
	}
	
	public Funcionario localizar(Integer id){
		return em.find(Funcionario.class, id);
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
