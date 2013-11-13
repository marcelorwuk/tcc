package com.gameware.tcc2.model;

public class Cliente {
	
	protected Integer idCliente;
	protected String nome;
	protected Integer idade;
	protected char sexo;
	protected char dataNascimento;
	protected char rg;
	protected char cpf;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public char getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(char dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public char getRg() {
		return rg;
	}
	public void setRg(char rg) {
		this.rg = rg;
	}
	public char getCpf() {
		return cpf;
	}
	public void setCpf(char cpf) {
		this.cpf = cpf;
	}
	
}