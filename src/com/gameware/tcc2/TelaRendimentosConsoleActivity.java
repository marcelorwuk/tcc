package com.gameware.tcc2;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class TelaRendimentosConsoleActivity extends ListActivity{

	public static final String TAG_CONSOLE = "consoleName";
	public static final String TAG_CONSOLE_REND = "consoleRend";
	private static final String TAG_CONSOLE_IMAGE = "imageView1";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_rendimentos_console);
		ArrayList<HashMap<String, String>> consoleList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		
		// adding each child node to HashMap key => value
		map.put(TAG_CONSOLE, "Mega-Drive");
		map.put(TAG_CONSOLE_REND, "R$400.00");
		map.put(TAG_CONSOLE_IMAGE, String.valueOf(R.drawable.ic_console_mega_drive));
		consoleList.add(map);
		
		map = new HashMap<String, String>();
		map.put(TAG_CONSOLE, "X-Box");
		map.put(TAG_CONSOLE_REND, "R$500.00");
		map.put(TAG_CONSOLE_IMAGE, String.valueOf(R.drawable.ic_console_xbox));
		consoleList.add(map);
		
		map = new HashMap<String, String>();
		map.put(TAG_CONSOLE, "Playstation");
		map.put(TAG_CONSOLE_REND, "R$200.00");
		map.put(TAG_CONSOLE_IMAGE, String.valueOf(R.drawable.ic_console_playstation));
		consoleList.add(map);
		
		ListAdapter adapter = new SimpleAdapter(this, consoleList,
				R.layout.activity_tela_rendimentos_console_item,
				new String[] { TAG_CONSOLE, TAG_CONSOLE_REND, "imageView1"}, new int[] {
				R.id.consoleName, R.id.consoleRend, R.id.imageView1});
		
		setListAdapter(adapter);
	}
	}
