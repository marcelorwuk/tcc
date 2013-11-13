package com.gameware.tcc2;

import com.gameware.tcc2.utils.GamewareUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastroClienteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_cadastro_cliente);
	}

	public void onButtonClick (View v){
		
		if (R.id.checkBox_sexo_F==v.getId()){
			CheckBox checkBoxSexoF = (CheckBox) findViewById(R.id.checkBox_sexo_F);
			CheckBox checkBoxSexoM = (CheckBox) findViewById(R.id.checkBox_sexo_M);
			if (checkBoxSexoF.isChecked()){
				checkBoxSexoM.setEnabled(false);
			}
			else if (!checkBoxSexoF.isChecked()){
				checkBoxSexoM.setEnabled(true);
			}
		}else if (R.id.checkBox_sexo_M==v.getId()){
			CheckBox checkBoxSexoF = (CheckBox) findViewById(R.id.checkBox_sexo_F);
			CheckBox checkBoxSexoM = (CheckBox) findViewById(R.id.checkBox_sexo_M);
			if (checkBoxSexoM.isChecked()){
				checkBoxSexoF.setEnabled(false);
			}
			else if (!checkBoxSexoM.isChecked()){
				checkBoxSexoF.setEnabled(true);
			}
		}
		else if (R.id.button_ok==v.getId()){
			EditText campoDataNascimento = (EditText) findViewById(R.id.text_data_nascimento);
			if (!GamewareUtils.validaData(campoDataNascimento.getText().toString())){
				Toast.makeText(TelaCadastroClienteActivity.this, "A Data de Nascimento deve estar no formato DD/MM/AAAA. Digite novamente.", Toast.LENGTH_SHORT).show();
			}
		}
	}
}
