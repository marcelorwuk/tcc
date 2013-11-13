package com.gameware.tcc2.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gameware.tcc2.model.Contato;

public class ContatoBanco extends Contato {
	
	public ContatoBanco(Context ctx){
		this.context = ctx;
	}
	
	static String NOME_TABELA = Contato.class.getCanonicalName();
	String SQL_CREATE_TABLE = "create table "+NOME_TABELA+"" +
			"("
			+idContato+" integer not null primary key autoincrement, "
			+idCliente+" integer not null primary key, "
			+idUsuario+" integer not null primary key, "
			+email+" text not null, " 
			+facebook+" text not null, "
			+gtalk+" text not null, "
			+facebook+" text not null, "
			+skype+" text not null, "
			+telefone+" text not null, "
			+whatsapp+" text not null, "
			+");";
	
	final Context context;
	SQLiteDatabase database;

}
