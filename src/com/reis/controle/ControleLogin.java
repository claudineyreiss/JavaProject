package com.reis.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.reis.beans.Funcionario;
import com.reis.modelo.FuncionarioDAO;
import com.reis.util.UtilMensagens;

@ManagedBean (name="controleLogin")
@SessionScoped
public class ControleLogin implements Serializable{
	
	private FuncionarioDAO dao;
	private Funcionario usuarioLogado;
	private String usuario;
	private String senha;
	
	public ControleLogin(){
		dao = new FuncionarioDAO();
	}
	
	public String paginaLogin(){
		return "/login";
	}
	
	public String efetuarLogin(){
		if (dao.login(usuario, senha)){
			usuarioLogado = dao.localizaPorNome(usuario);
			UtilMensagens.mensagemInformacao("Login efetuado com sucesso!");
			return "/index";
		} else {
			UtilMensagens.mensagemErro("Erro ao efetuar o login usuario ou senha invalidos!");
			return "/login";
		}
	}
	
	public String efetuarLogout(){
		usuarioLogado = null;
		return "/index";
	}
	
	public FuncionarioDAO getDao() {
		return dao;
	}
	public void setDao(FuncionarioDAO dao) {
		this.dao = dao;
	}
	public Funcionario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Funcionario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
