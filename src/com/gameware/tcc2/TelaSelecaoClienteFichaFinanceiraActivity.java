package com.gameware.tcc2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaSelecaoClienteFichaFinanceiraActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_selecao_cliente_ficha_financeira);
	}

	public void onButtonClick (View v){
		if (R.id.button_ok==v.getId()){
			Intent intent = new Intent(TelaSelecaoClienteFichaFinanceiraActivity.this,TelaFichaFinanceiraClienteActivity.class);
			startActivity(intent);
		}
	}
}
