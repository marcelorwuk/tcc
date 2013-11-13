package com.gameware.tcc2.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gameware.tcc2.model.Locacao;

public class LocacaoBanco extends Locacao {
	
	public LocacaoBanco(Context ctx){
		this.context = ctx;
	}
	
	static String NOME_TABELA = Locacao.class.getCanonicalName();
	String SQL_CREATE_TABLE = "create table "+NOME_TABELA+"" +
			"("
			+idLocacao+" integer not null primary key autoincrement, "
			+idCliente+" integer not null primary key, " 
			+idEquipamento+" integer not null primary key, "
			+valorGasto+" integer not null, "
			+inicioLocacao+" date not null, "
			+fimLocacao+"date not null "
			+");";
	
	final Context context;
	SQLiteDatabase database;

}
