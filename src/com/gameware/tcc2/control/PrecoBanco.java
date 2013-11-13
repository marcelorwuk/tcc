package com.gameware.tcc2.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gameware.tcc2.model.Preco;

public class PrecoBanco extends Preco {
	
	public PrecoBanco(Context ctx){
		this.context = ctx;
	}
	
	static String NOME_TABELA = Preco.class.getCanonicalName();
	String SQL_CREATE_TABLE = "create table "+NOME_TABELA+"" +
			"("
			+idPreco+" integer not null primary key autoincrement, "
			+valorMonetario+" integer not null, " 
			+inicioValidadePreco+" date not null, "
			+fimValidadePreco+" date not null "
			+");";
	
	final Context context;
	SQLiteDatabase database;

}
