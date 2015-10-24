/*******************************************************************************
 * Copyright 2013 Gabriele Mariotti
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package it.gmariotti.android.examples.antipattern;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListActivity;

public class MainActivity extends SherlockListActivity {

	

	public static final String[] options = { "Scenario 1: Freezing the UI with a BroadcastReceiver" ,
											 "Scenario 2: Freezing the UI with a AsyncTask" ,
											 "Scenario 3: Freezing the UI with a Service" ,
											 "Scenario 4: Freezing the UI with an IntentService"
										};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent=null;

		switch (position) {
			default:
			case 0:
				intent = new Intent(this, FreezingActivity.class);
				break;
			case 1:
				intent = new Intent(this, AsyncFreezingActivity.class);
				break;
			case 2:
				intent = new Intent(this, ServiceFreezingActivity.class);
				break;		
			case 3:
				intent = new Intent(this, IntentServiceFreezingActivity.class);
				break;	
		}
		
		if (intent!=null)
			startActivity(intent);
	}



}
