package com.gameware.tcc2.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gameware.tcc2.model.Cliente;

public class ClienteBanco extends Cliente {
	
	public ClienteBanco(Context ctx){
		this.context = ctx;
	}
	
	static String NOME_TABELA = Cliente.class.getCanonicalName();
	String SQL_CREATE_TABLE = "create table "+NOME_TABELA+"" +
			"("
			+idCliente+" integer not null primary key autoincrement, "
			+cpf+" integer not null primary key, "
			+dataNascimento+" date not null, " 
			+nome+" text not null, "
			+rg+" integer not null, "
			+sexo+"char not null, "
			+idade+" integer not null "
			+");";
	
	final Context context;
	SQLiteDatabase database;

}
