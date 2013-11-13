package com.gameware.tcc2;

import com.gameware.tcc2.utils.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLogin extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		EditText login = (EditText) findViewById(R.id.text_login);
		EditText senha = (EditText) findViewById(R.id.text_senha);
		login.setText(Constants.EMPTY);
		senha.setText(Constants.EMPTY);
		super.onResume();
	}
	
	public void onButtonClick (View v){
		
		EditText login = (EditText) findViewById(R.id.text_login);
		EditText senha = (EditText) findViewById(R.id.text_senha);
		
		/*Verifica se os campos estão preenchidos*/
		if (R.id.button_conectar==v.getId()){
			if (login.getText().toString().equals(Constants.EMPTY)){
				Toast.makeText(TelaLogin.this, "Informe o Login", Toast.LENGTH_SHORT).show();
			}
			else if (senha.getText().toString().equals(Constants.EMPTY)){
				Toast.makeText(TelaLogin.this, "Informe a Senha", Toast.LENGTH_SHORT).show();
			}
			
			/*Temporario - Administrador ou Gerente*/
			if (login.getText().toString().equals("1") && senha.getText().toString().equals("1")){
				Intent intent = new Intent(TelaLogin.this,TelaMenuGerenteActivity.class);
				startActivity(intent);
			}
			else if (login.getText().toString().equals("2") && senha.getText().toString().equals("2")){
				Intent intent = new Intent(TelaLogin.this,TelaMenuAdministradorActivity.class);
				startActivity(intent);
			}
		}
	}
}