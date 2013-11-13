package com.gameware.tcc2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaGerenciarClienteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_gerenciar_cliente);
	}

	public void onButtonClick(View v){
		if (R.id.button_dados_cadastrais==v.getId()){
			Intent intent = new Intent(TelaGerenciarClienteActivity.this,TelaDadosCadastraisClienteActivity.class);
			startActivity(intent);
		}
		else if (R.id.button_ficha_financeira==v.getId()){
			Intent intent = new Intent(TelaGerenciarClienteActivity.this,TelaSelecaoClienteFichaFinanceiraActivity.class);
			startActivity(intent);
		}
		else if (R.id.button_cadastrar_cliente==v.getId()){
			Intent intent = new Intent(TelaGerenciarClienteActivity.this,TelaCadastroClienteActivity.class);
			startActivity(intent);
		}
	}
}