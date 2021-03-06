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
package it.gmariotti.android.examples.receiver;

import java.util.Set;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyTestReceiver extends BroadcastReceiver {

	private static final String TAG = "MyTestReceiver";

	public MyTestReceiver() {
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO: This method is called when the BroadcastReceiver is receiving
		// an Intent broadcast.
		Log.i(TAG, "new Intent Received ");
		Log.i(TAG, "Intent Action:" + intent.getAction());

		Set<String> categories = intent.getCategories();
		if (categories != null) {
			for (String category : intent.getCategories())
				Log.i(TAG, "new Intent Category:" + category);
		}

		if (intent.getData() != null)
			Log.i(TAG, "Intent Data:" + intent.getData().toString());

		Bundle extras = intent.getExtras();
		if (extras != null) {
			for (String key : extras.keySet()) {
				Log.i(TAG, "Intent Extra key=" + key + ":" + extras.get(key));
			}
		}

	}
}
