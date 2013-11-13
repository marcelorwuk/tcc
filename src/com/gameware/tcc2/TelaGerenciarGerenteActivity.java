package com.gameware.tcc2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaGerenciarGerenteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_gerenciar_gerente);
	}

	public void onButtonClick (View v){
		if (R.id.button_dados_cadastrais==v.getId()){
			Intent intent = new Intent(TelaGerenciarGerenteActivity.this,TelaDadosCadastraisGerenteActivity.class);
			startActivity(intent);			
		}
		else if (R.id.button_cadastrar_gerente==v.getId()){
			Intent intent = new Intent(TelaGerenciarGerenteActivity.this,TelaCadastroGerenteActivity.class);
			startActivity(intent);
		}
	}
}