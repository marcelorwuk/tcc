package com.gameware.tcc2.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gameware.tcc2.model.Equipamento;

public class EquipamentoBanco extends Equipamento {
	
	public EquipamentoBanco(Context ctx){
		this.context = ctx;
	}
	
	static String NOME_TABELA = Equipamento.class.getCanonicalName();
	String SQL_CREATE_TABLE = "create table "+NOME_TABELA+"" +
			"("
			+idEquipamento+" integer not null primary key autoincrement, "
			+nome+" text not null, "
			+tipoEquipamento+" text not null "
			+");";
	
	final Context context;
	SQLiteDatabase database;

}
