package com.gameware.tcc2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class TelaCadastroProduto extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_cadastro_produto);
		Spinner seletorDesconto = (Spinner) findViewById(R.id.seletor_desconto);
		seletorDesconto.setEnabled(false);
		Spinner seletorCategoria = (Spinner) findViewById(R.id.seletor_categoria);
		seletorCategoria.setEnabled(false);
	}

	public void onButtonClick (View v){
		if (R.id.checkBox_validade==v.getId()){
			CheckBox checkBoxValidade = (CheckBox) findViewById(R.id.checkBox_validade);
			if (checkBoxValidade.isChecked()){
				EditText textFieldValidadePreco = (EditText) findViewById(R.id.text_validade_preco);
				textFieldValidadePreco.setEnabled(true);
			}
			else if (!checkBoxValidade.isChecked()){
				EditText textFieldValidadePreco = (EditText) findViewById(R.id.text_validade_preco);
				textFieldValidadePreco.setEnabled(false);
			}
		}else if (R.id.checkBox_desconto==v.getId()){
			CheckBox checkBoxDesconto = (CheckBox) findViewById(R.id.checkBox_desconto);
			if (checkBoxDesconto.isChecked()){
				Spinner seletorDesconto = (Spinner) findViewById(R.id.seletor_desconto);
				seletorDesconto.setEnabled(true);
			}
			else if (!checkBoxDesconto.isChecked()){
				Spinner seletorDesconto = (Spinner) findViewById(R.id.seletor_desconto);
				seletorDesconto.setEnabled(false);
			}
		}
		
	}
}