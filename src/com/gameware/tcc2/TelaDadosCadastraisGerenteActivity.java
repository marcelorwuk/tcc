package com.gameware.tcc2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.gameware.tcc2.utils.GamewareUtils;

public class TelaDadosCadastraisGerenteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_dados_cadastrais_gerente);
	}

	public void onButtonClick (View v){
		
		if (R.id.checkBox_editar==v.getId()){
			CheckBox checkBoxEditar = (CheckBox) findViewById(R.id.checkBox_editar);
			if (checkBoxEditar.isChecked()){
				EditText textFieldNomeCompleto = (EditText) findViewById(R.id.text_nome_completo);
				textFieldNomeCompleto.setEnabled(true);
				CheckBox checkBoxSexoM = (CheckBox) findViewById(R.id.checkBox_sexo_M);
				checkBoxSexoM.setEnabled(true);
				CheckBox checkBoxSexoF = (CheckBox) findViewById(R.id.checkBox_sexo_F);
				checkBoxSexoF.setEnabled(true);
				EditText textFieldDataNascimento = (EditText) findViewById(R.id.text_data_nascimento);
				textFieldDataNascimento.setEnabled(true);
				EditText textFieldRg = (EditText) findViewById(R.id.text_rg);
				textFieldRg.setEnabled(true);
				EditText textFieldTelefone = (EditText) findViewById(R.id.text_telefone);
				textFieldTelefone.setEnabled(true);
				EditText textFieldEmail = (EditText) findViewById(R.id.text_email);
				textFieldEmail.setEnabled(true);
			}
			else if (!checkBoxEditar.isChecked()){
				EditText textFieldNomeCompleto = (EditText) findViewById(R.id.text_nome_completo);
				textFieldNomeCompleto.setEnabled(false);
				CheckBox checkBoxSexoM = (CheckBox) findViewById(R.id.checkBox_sexo_M);
				checkBoxSexoM.setEnabled(false);
				CheckBox checkBoxSexoF = (CheckBox) findViewById(R.id.checkBox_sexo_F);
				checkBoxSexoF.setEnabled(false);
				EditText textFieldDataNascimento = (EditText) findViewById(R.id.text_data_nascimento);
				textFieldDataNascimento.setEnabled(false);
				EditText textFieldRg = (EditText) findViewById(R.id.text_rg);
				textFieldRg.setEnabled(false);
				EditText textFieldTelefone = (EditText) findViewById(R.id.text_telefone);
				textFieldTelefone.setEnabled(false);
				EditText textFieldEmail = (EditText) findViewById(R.id.text_email);
				textFieldEmail.setEnabled(false);
			}
		}else if (R.id.checkBox_sexo_F==v.getId()){
			CheckBox checkBoxSexoF = (CheckBox) findViewById(R.id.checkBox_sexo_F);
			CheckBox checkBoxSexoM = (CheckBox) findViewById(R.id.checkBox_sexo_M);
			if (checkBoxSexoF.isChecked()){
				checkBoxSexoM.setChecked(false);
			}
			else if (!checkBoxSexoF.isChecked()){
				checkBoxSexoM.setChecked(true);
			}
		}else if (R.id.checkBox_sexo_M==v.getId()){
			CheckBox checkBoxSexoF = (CheckBox) findViewById(R.id.checkBox_sexo_F);
			CheckBox checkBoxSexoM = (CheckBox) findViewById(R.id.checkBox_sexo_M);
			if (checkBoxSexoM.isChecked()){
				checkBoxSexoF.setChecked(false);
			}
			else if (!checkBoxSexoM.isChecked()){
				checkBoxSexoF.setChecked(true);
			}
		} else if (R.id.button_ok == v.getId()) {
			CheckBox checkBoxEditar = (CheckBox) findViewById(R.id.checkBox_editar);
			if (checkBoxEditar.isChecked()) {
				EditText campoDataNascimento = (EditText) findViewById(R.id.text_data_nascimento);
				if (!GamewareUtils.validaData(campoDataNascimento.getText().toString())) {
					Toast.makeText(TelaDadosCadastraisGerenteActivity.this,"A Data de Nascimento deve estar no formato DD/MM/AAAA. Digite novamente.",Toast.LENGTH_LONG).show();
				}
			}
		}
	}

}
