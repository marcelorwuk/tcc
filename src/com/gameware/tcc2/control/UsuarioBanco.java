package com.gameware.tcc2.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gameware.tcc2.model.Usuario;

public class UsuarioBanco extends Usuario {
	
	public UsuarioBanco(Context ctx){
		this.context = ctx;
	}
	
	static String NOME_TABELA = Usuario.class.getCanonicalName();
	String SQL_CREATE_TABLE = "create table "+NOME_TABELA+"" +
			"("
			+idUsuario+" integer not null primary key autoincrement, "
			+tipoUsuario+" text not null, "
			+login+" text not null, " 
			+senha+" text not null "
			+");";
	
	final Context context;
	SQLiteDatabase database;

}
