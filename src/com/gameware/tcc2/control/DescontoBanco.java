package com.gameware.tcc2.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gameware.tcc2.model.Desconto;

public class DescontoBanco extends Desconto {
	
	public DescontoBanco(Context ctx){
		this.context = ctx;
	}
	
	static String NOME_TABELA = Desconto.class.getCanonicalName();
	String SQL_CREATE_TABLE = "create table "+NOME_TABELA+"" +
			"("
			+idDesconto+" integer not null primary key autoincrement, "
			+inicioValidade+" date not null, " 
			+fimValidade+" date not null, "
			+porcentagemDesconto+" integer not null "
			+");";
	
	final Context context;
	SQLiteDatabase database;

}
