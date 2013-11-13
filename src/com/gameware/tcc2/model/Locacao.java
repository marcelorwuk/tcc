package com.gameware.tcc2.model;

import java.util.Date;

public class Locacao {

	protected Integer idLocacao;
	protected Integer idCliente;
	protected Integer idEquipamento;
	protected float valorGasto;
	protected Date inicioLocacao;
	protected Date fimLocacao;

	public Integer getIdLocacao() {
		return idLocacao;
	}
	public void setIdLocacao(Integer idLocacao) {
		this.idLocacao = idLocacao;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdEquipamento() {
		return idEquipamento;
	}
	public void setIdEquipamento(Integer idEquipamento) {
		this.idEquipamento = idEquipamento;
	}
	public float getValorGasto() {
		return valorGasto;
	}
	public void setValorGasto(float valorGasto) {
		this.valorGasto = valorGasto;
	}
	public Date getInicioLocacao() {
		return inicioLocacao;
	}
	public void setInicioLocacao(Date inicioLocacao) {
		this.inicioLocacao = inicioLocacao;
	}
	public Date getFimLocacao() {
		return fimLocacao;
	}
	public void setFimLocacao(Date fimLocacao) {
		this.fimLocacao = fimLocacao;
	}
	
}