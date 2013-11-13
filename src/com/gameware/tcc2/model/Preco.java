package com.gameware.tcc2.model;

import java.util.Date;

public class Preco {
	
	protected Integer idPreco;
	protected Date inicioValidadePreco;
	protected Date fimValidadePreco;
	protected float valorMonetario;
	
	public Integer getIdPreco() {
		return idPreco;
	}
	public void setIdPreco(Integer idPreco) {
		this.idPreco = idPreco;
	}
	public Date getInicioValidadePreco() {
		return inicioValidadePreco;
	}
	public void setInicioValidadePreco(Date inicioValidadePreco) {
		this.inicioValidadePreco = inicioValidadePreco;
	}
	public Date getFimValidadePreco() {
		return fimValidadePreco;
	}
	public void setFimValidadePreco(Date fimValidadePreco) {
		this.fimValidadePreco = fimValidadePreco;
	}
	public float getValorMonetario() {
		return valorMonetario;
	}
	public void setValorMonetario(float valorMonetario) {
		this.valorMonetario = valorMonetario;
	}
	
}