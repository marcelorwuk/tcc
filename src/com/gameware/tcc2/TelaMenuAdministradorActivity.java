package com.gameware.tcc2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaMenuAdministradorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_menu_administrador);
	}

	public void onButtonClick(View v){
		if (R.id.button_ger_financeiro==v.getId()){
			Intent intent = new Intent(TelaMenuAdministradorActivity.this,TelaGerenciarGerenteActivity.class);
			startActivity(intent);	
		}else if (R.id.button_logout==v.getId()){
		    AlertDialog.Builder builder = new AlertDialog.Builder(this);
		    builder.setMessage("Você tem certeza que deseja sair?")
		           .setCancelable(false)
		           .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int id) {
		       			finish();
		               }
		           })
		           .setNegativeButton("Não", new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int id) {
		                    dialog.cancel();
		               }
		           });
		    AlertDialog alert = builder.create();
		    alert.show();
		}
	}
}