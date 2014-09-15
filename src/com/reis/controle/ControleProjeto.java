package com.reis.controle;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.beanutils.converters.ConverterFacade;

import com.reis.beans.Funcionario;
import com.reis.beans.Projeto;
import com.reis.beans.ProjetoFuncionario;
import com.reis.conversores.ConverterFuncionario;
import com.reis.conversores.ConverterSetor;
import com.reis.modelo.FuncionarioDAO;
import com.reis.modelo.ProjetoDAO;
import com.reis.modelo.SetorDAO;

@ManagedBean (name="controleProjeto")
@SessionScoped
public class ControleProjeto implements Serializable{

	private ProjetoDAO dao;
	private Projeto objeto;
	private FuncionarioDAO daoFuncionario;
	private ConverterFuncionario converterFuncionario;
	private SetorDAO daoSetor;
	private ConverterSetor converterSetor;
	private Funcionario funcionario;
	private Integer cargaHoraria;
	private Boolean gestor;
	private Date inicioParticipacao;
	private Date fimParticipacao;
	private Boolean addFunc = false;
	
	public ControleProjeto(){
		dao = new ProjetoDAO();
		daoFuncionario = new FuncionarioDAO();
		converterFuncionario = new ConverterFuncionario();
		daoSetor = new SetorDAO();
		converterSetor = new ConverterSetor();
	}
	
	public String listar(){
		return "/privado/projeto/listar?faces-redirect=true";
	}
	
	public String novo(){
		objeto = new Projeto();
		addFunc = false;
		return "form";		
	}
	
	public String cancelar(){
		addFunc = false;
		dao.rollback();
		return "listar";
	}
	
	public String gravar(){
		if (dao.gravar(objeto)){
			addFunc = false;
			return "listar";
		}else{
			return "form";
		}
	}
	
	public String alterar(Projeto obj){
		objeto = obj;
		addFunc = false;

		return "form";
	}
	
	public String excluir(Projeto obj){
		dao.excluir(obj);
		return "listar";
	}

	public void removerFuncionario(ProjetoFuncionario obj){
		objeto.removerFuncionario(obj);
	}
	
	public void adicionarFuncionario(){
		addFunc = true;
	}
	
	public void cancelarFuncionario(){
		addFunc = false;
	}
	
	public void salvarFuncionario(){
		ProjetoFuncionario obj = new ProjetoFuncionario();
		obj.setCargaHoraria(cargaHoraria);
		obj.setFuncionario(funcionario);
		obj.setInicioParticipacao(inicioParticipacao);
		obj.setFimParticipacao(fimParticipacao);
		obj.setGestor(gestor);
		objeto.adicionarFuncionario(obj);
		addFunc = false;
		
		cargaHoraria = null;
		funcionario = null;
		fimParticipacao = null;
		gestor = null;
		inicioParticipacao = null;
		
	}
	
	public ProjetoDAO getDao() {
		return dao;
	}

	public void setDao(ProjetoDAO dao) {
		this.dao = dao;
	}

	public Projeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Projeto objeto) {
		this.objeto = objeto;
	}

	public FuncionarioDAO getDaoFuncionario() {
		return daoFuncionario;
	}

	public void setDaoFuncionario(FuncionarioDAO daoFuncionario) {
		this.daoFuncionario = daoFuncionario;
	}

	public ConverterFuncionario getConverterFuncionario() {
		return converterFuncionario;
	}

	public void setConverterFuncionario(ConverterFuncionario converterFuncionario) {
		this.converterFuncionario = converterFuncionario;
	}

	public SetorDAO getDaoSetor() {
		return daoSetor;
	}

	public void setDaoSetor(SetorDAO daoSetor) {
		this.daoSetor = daoSetor;
	}

	public ConverterSetor getConverterSetor() {
		return converterSetor;
	}

	public void setConverterSetor(ConverterSetor converterSetor) {
		this.converterSetor = converterSetor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Boolean getGestor() {
		return gestor;
	}

	public void setGestor(Boolean gestor) {
		this.gestor = gestor;
	}

	public Date getInicioParticipacao() {
		return inicioParticipacao;
	}

	public void setInicioParticipacao(Date inicioParticipacao) {
		this.inicioParticipacao = inicioParticipacao;
	}

	public Date getFimParticipacao() {
		return fimParticipacao;
	}

	public void setFimParticipacao(Date fimParticipacao) {
		this.fimParticipacao = fimParticipacao;
	}

	public Boolean getAddFunc() {
		return addFunc;
	}

	public void setAddFunc(Boolean addFunc) {
		this.addFunc = addFunc;
	}
	
	
	
	
}
