package com.gameware.tcc2.model;

public class Desconto {
	
	protected int idDesconto;
	protected int porcentagemDesconto;
	protected int inicioValidade;
	protected int fimValidade;
	
	public int getIdDesconto() {
		return idDesconto;
	}
	public void setIdDesconto(int idDesconto) {
		this.idDesconto = idDesconto;
	}
	public int getPorcentagemDesconto() {
		return porcentagemDesconto;
	}
	public void setPorcentagemDesconto(int porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}
	public int getInicioValidade() {
		return inicioValidade;
	}
	public void setInicioValidade(int inicioValidade) {
		this.inicioValidade = inicioValidade;
	}
	public int getFimValidade() {
		return fimValidade;
	}
	public void setFimValidade(int fimValidade) {
		this.fimValidade = fimValidade;
	}

}
