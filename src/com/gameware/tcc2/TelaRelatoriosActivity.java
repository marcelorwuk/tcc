package com.gameware.tcc2;

import com.gameware.tcc2.utils.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaRelatoriosActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_relatorios);
	}


	public void onButtonClick(View v) {
		if (R.id.button_rel_dia == v.getId()) {
			Bundle bundle = new Bundle();
			bundle.putInt(Constants.SESSION_PERIOD_OPTION, Constants.PERIODO_DIA);
			Intent intent = new Intent(TelaRelatoriosActivity.this,CalendarioActivity.class);
			intent.putExtras(bundle);
			startActivity(intent);
		}else if (R.id.button_rel_sem == v.getId()) {
			Bundle bundle = new Bundle();
			bundle.putInt(Constants.SESSION_PERIOD_OPTION, Constants.PERIODO_SEM);
			Intent intent = new Intent(TelaRelatoriosActivity.this,CalendarioActivity.class);
			intent.putExtras(bundle);
			startActivity(intent);
		}else if (R.id.button_rel_men == v.getId()) {
			Bundle bundle = new Bundle();
			bundle.putInt(Constants.SESSION_PERIOD_OPTION, Constants.PERIODO_MES);
			Intent intent = new Intent(TelaRelatoriosActivity.this,CalendarioActivity.class);
			intent.putExtras(bundle);
			startActivity(intent);
		}else if (R.id.button_rel_anu == v.getId()) {
			Bundle bundle = new Bundle();
			bundle.putInt(Constants.SESSION_PERIOD_OPTION, Constants.PERIODO_ANO);
			Intent intent = new Intent(TelaRelatoriosActivity.this,CalendarioActivity.class);
			intent.putExtras(bundle);
			startActivity(intent);
		}else if (R.id.button_rel_per == v.getId())	{
			Bundle bundle = new Bundle();
			bundle.putInt(Constants.SESSION_PERIOD_OPTION, Constants.PERIODO_PER);
			Intent intent = new Intent(TelaRelatoriosActivity.this,CalendarioActivity.class);
			intent.putExtras(bundle);
			startActivity(intent);
		}
	}
}
