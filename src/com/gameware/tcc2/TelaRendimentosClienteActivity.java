package com.gameware.tcc2;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class TelaRendimentosClienteActivity extends ListActivity{

	public static final String TAG_CLIENT_NAME = "clientName";
	public static final String TAG_CLIENT_REND = "clientRend";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_rendimentos_cliente);
		ArrayList<HashMap<String, String>> consoleList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		
		// adding each child node to HashMap key => value
		map.put(TAG_CLIENT_NAME, "Carlos Eduardo");
		map.put(TAG_CLIENT_REND, "R$400.00");
		consoleList.add(map);
		
		map = new HashMap<String, String>();
		map.put(TAG_CLIENT_NAME, "Fabio Ricardo");
		map.put(TAG_CLIENT_REND, "R$500.00");
		consoleList.add(map);
		
		ListAdapter adapter = new SimpleAdapter(this, consoleList,
				R.layout.activity_tela_rendimentos_cliente_item,
				new String[] { TAG_CLIENT_NAME, TAG_CLIENT_REND}, new int[] {
				R.id.clientName, R.id.clientRend});
		
		setListAdapter(adapter);		
		
	}
}