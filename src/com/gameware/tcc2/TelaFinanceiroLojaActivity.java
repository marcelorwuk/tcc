package com.gameware.tcc2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaFinanceiroLojaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_financeiro_loja);
	}
	
	public void onButtonClick (View v){
		
		if (R.id.button_relatorios==v.getId()){
			Intent intent = new Intent(TelaFinanceiroLojaActivity.this,TelaRelatoriosActivity.class);
			startActivity(intent);
		}
		else if (R.id.button_valor_utilizacao==v.getId()){
			Intent intent = new Intent(TelaFinanceiroLojaActivity.this,TelaGerenciarValoresServico.class);
			startActivity(intent);
		}
	}

}