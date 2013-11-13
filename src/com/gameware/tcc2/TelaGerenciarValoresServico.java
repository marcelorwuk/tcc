package com.gameware.tcc2;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class TelaGerenciarValoresServico extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_gerenciar_valores_servico);
		List<String> lista = new ArrayList<String>();
		lista.add("Mega-Drive");
		lista.add("Nintendo");
		lista.add("Playstation");
		lista.add("X-Box");
		lista.add("Dreamcast");
        Spinner s = (Spinner) findViewById(R.id.seletor_console);
        @SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, lista);
        s.setAdapter(adapter);
	}

	public void onButtonClick(View v){
		
		TextView textView = (TextView) findViewById(R.id.label_tipo_desconto);
		Spinner spinner = (Spinner) findViewById(R.id.seletor_tipo_desconto);
		CheckBox checkBox = (CheckBox) findViewById(R.id.opcao_definir_desconto);
		if (R.id.opcao_definir_desconto == v.getId()) {
			if (checkBox.isChecked()) {
				textView.setVisibility(View.VISIBLE);
				spinner.setVisibility(View.VISIBLE);
			} else if (!checkBox.isChecked()) {
				textView.setVisibility(View.INVISIBLE);
				spinner.setVisibility(View.INVISIBLE);
			}
		}
	}
	
}
