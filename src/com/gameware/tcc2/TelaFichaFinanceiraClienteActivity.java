package com.gameware.tcc2;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class TelaFichaFinanceiraClienteActivity extends ListActivity {

	public static final String TAG_FINANC_DATE = "financDate";
	public static final String TAG_CONSOLE_NAME = "consoleName";
	public static final String TAG_CONSOLE_REND = "consoleRend";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_ficha_financeira_cliente);
		
		ArrayList<HashMap<String, String>> consoleList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		
		// adding each child node to HashMap key => value
		map.put(TAG_FINANC_DATE, "01/01/2001 15:30");
		map.put(TAG_CONSOLE_NAME, "Mega-Drive");
		map.put(TAG_CONSOLE_REND, "R$400.00");
		consoleList.add(map);
		
		map = new HashMap<String, String>();
		map.put(TAG_FINANC_DATE, "02/01/2001 15:30");
		map.put(TAG_CONSOLE_NAME, "Mega-Drive");
		map.put(TAG_CONSOLE_REND, "R$500.00");
		consoleList.add(map);
		
		map = new HashMap<String, String>();
		map.put(TAG_FINANC_DATE, "05/01/2001 15:30");
		map.put(TAG_CONSOLE_NAME, "Playstation");
		map.put(TAG_CONSOLE_REND, "R$800.00");
		consoleList.add(map);
		
		ListAdapter adapter = new SimpleAdapter(this, consoleList,
				R.layout.activity_tela_ficha_financeira_cliente_item,
				new String[] { TAG_FINANC_DATE, TAG_CONSOLE_NAME, TAG_CONSOLE_REND}, new int[] {
				R.id.financDate, R.id.consoleName, R.id.consoleRend});
		
		setListAdapter(adapter);
	}
	
}