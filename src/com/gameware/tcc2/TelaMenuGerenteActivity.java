package com.gameware.tcc2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaMenuGerenteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_menu_gerente);
	}

	public void onButtonClick (View v){
		
		if (R.id.button_ger_clientes==v.getId()){
			Intent intent = new Intent(TelaMenuGerenteActivity.this,TelaGerenciarClienteActivity.class);
			startActivity(intent);
		}else if (R.id.button_ger_financeiro==v.getId()){
			Intent intent = new Intent(TelaMenuGerenteActivity.this,TelaFinanceiroLojaActivity.class);
			startActivity(intent);
		}else if (R.id.button_produtos==v.getId()){
			Intent intent = new Intent(TelaMenuGerenteActivity.this,TelaGerenciarProdutosActivity.class);
			startActivity(intent);
		}else if (R.id.button_consoles==v.getId()){
			Intent intent = new Intent(TelaMenuGerenteActivity.this,TelaConsolesActivity.class);
			startActivity(intent);
		}else if (R.id.button_logout == v.getId()) {
			if (R.id.button_logout == v.getId()) {
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setMessage("Você tem certeza que deseja sair?")
						.setCancelable(false)
						.setPositiveButton("Sim",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,int id) {
										finish();
									}
								})
						.setNegativeButton("Não",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,int id) {
										dialog.cancel();
									}
								});
				AlertDialog alert = builder.create();
				alert.show();
			}
		}
	}
}