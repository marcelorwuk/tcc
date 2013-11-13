package com.gameware.tcc2;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TelaRegistroLocacao extends Activity {

	private static final String TAG_CONSOLE = "consoleName";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_registro_locacao);
		
        // getting intent data
        Intent in = getIntent();
        
        // Get JSON values from previous intent
        String consoleName = in.getStringExtra(TAG_CONSOLE);
		System.out.println(consoleName);
		
		List<String> listaCliente = new ArrayList<String>();
		listaCliente.add("Fabio Eduardo");
		listaCliente.add("Mirosmar José de Camargo");
		listaCliente.add("Carlos Ricardo");
		listaCliente.add("Fernando Locatelli");
		Spinner s = (Spinner) findViewById(R.id.seletor_gerente);
        @SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, listaCliente);
        s.setAdapter(adapter);
		
		List<String> listaMinutos = new ArrayList<String>();
		listaMinutos.add("00");
		listaMinutos.add("15");
		listaMinutos.add("30");
		listaMinutos.add("45");
        Spinner s1 = (Spinner) findViewById(R.id.seletor_minuto);
        @SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, listaMinutos);
        s1.setAdapter(adapter1);
        
	}


}
