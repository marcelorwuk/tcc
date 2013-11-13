package com.gameware.tcc2;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class TelaConsolesActivity extends ListActivity {

	// JSON Node names
	private static final String TAG_CONSOLE = "consoleName";
	private static final String TAG_CONSOLE_DESC = "consoleDesc";
	private static final String TAG_CONSOLE_IMAGE = "imageView1";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_consoles);
		ArrayList<HashMap<String, String>> consoleList = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<String, String>();
			
			// adding each child node to HashMap key => value
			map.put(TAG_CONSOLE, "Mega-Drive");
			map.put(TAG_CONSOLE_DESC, "Console 1");
			map.put(TAG_CONSOLE_IMAGE, String.valueOf(R.drawable.ic_console_mega_drive));
			consoleList.add(map);
			
			map = new HashMap<String, String>();
			map.put(TAG_CONSOLE, "Mega-Drive");
			map.put(TAG_CONSOLE_DESC, "Console 2");
			map.put(TAG_CONSOLE_IMAGE, String.valueOf(R.drawable.ic_console_mega_drive));
			consoleList.add(map);
			
			map = new HashMap<String, String>();
			map.put(TAG_CONSOLE, "X-Box");
			map.put(TAG_CONSOLE_DESC, "Console 1");
			map.put(TAG_CONSOLE_IMAGE, String.valueOf(R.drawable.ic_console_xbox));
			consoleList.add(map);
			
			map = new HashMap<String, String>();
			map.put(TAG_CONSOLE, "Playstation");
			map.put(TAG_CONSOLE_DESC, "Console 1");
			map.put(TAG_CONSOLE_IMAGE, String.valueOf(R.drawable.ic_console_playstation));
			consoleList.add(map);
			
			map = new HashMap<String, String>();
			map.put(TAG_CONSOLE, "Playstation");
			map.put(TAG_CONSOLE_DESC, "Console 2");
			map.put(TAG_CONSOLE_IMAGE, String.valueOf(R.drawable.ic_console_playstation));
			consoleList.add(map);
			
			map = new HashMap<String, String>();
			map.put(TAG_CONSOLE, "Nintendo");
			map.put(TAG_CONSOLE_DESC, "Console 1");
			map.put(TAG_CONSOLE_IMAGE, String.valueOf(R.drawable.ic_console_nintendo));
			consoleList.add(map);
			
			ListAdapter adapter = new SimpleAdapter(this, consoleList,
					R.layout.activity_tela_consoles_item,
					new String[] { TAG_CONSOLE, TAG_CONSOLE_DESC, "imageView1"}, new int[] {
					R.id.consoleName, R.id.consoleDesc, R.id.imageView1});
			
			setListAdapter(adapter);
			
			// selecting single ListView item
			ListView lv = getListView();
			
			// Launching new screen on Selecting Single ListItem
			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
					// getting values from selected ListItem
					String consoleName = ((TextView) view.findViewById(R.id.consoleName)).getText().toString();
					// Starting new intent
					Intent in = new Intent(getApplicationContext(), TelaRegistroLocacao.class);
					in.putExtra(TAG_CONSOLE, consoleName);
					startActivity(in);
				}

			});
	}



}
