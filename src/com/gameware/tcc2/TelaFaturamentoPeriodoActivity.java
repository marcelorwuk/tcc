package com.gameware.tcc2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaFaturamentoPeriodoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_faturamento_periodo);
	}

	public void onButtonClick (View v){
		if (R.id.button_rendimentos_cliente==v.getId()){
			Intent intent = new Intent(TelaFaturamentoPeriodoActivity.this,TelaRendimentosClienteActivity.class);
			startActivity(intent);			
		}else if (R.id.button_rendimentos_console==v.getId()){
			Intent intent = new Intent(TelaFaturamentoPeriodoActivity.this,TelaRendimentosConsoleActivity.class);
			startActivity(intent);					
		}
	}
}