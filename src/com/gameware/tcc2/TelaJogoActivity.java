package com.gameware.tcc2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class TelaJogoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_jogo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_jogo, menu);
		return true;
	}

}
