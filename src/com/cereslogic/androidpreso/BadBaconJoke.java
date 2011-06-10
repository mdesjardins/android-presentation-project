package com.cereslogic.androidpreso;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

public class BadBaconJoke extends Activity {
	private ProgressDialog progressDialog;

	@Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.progressDialog = 
    	ProgressDialog.show(
    			this,							  
    			"working...",
    			"Some pancakes, eggs, and bacon walk into a bar. Bartender looks at them and says..."
    	);
    new PunchlineTask().execute();
	}
	
	
	private class PunchlineTask extends AsyncTask<Void, Void, String> {
	  @Override
	  protected String doInBackground(Void... params) {
	  	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return "...hey! We don't serve breakfast here!";
	  }

	  @Override
	  protected void onPostExecute(String result) {
	  	progressDialog.dismiss();
	   	new AlertDialog.Builder(BadBaconJoke.this)
   		.setMessage(result).setCancelable(false).setTitle("Punchline")
   		.setPositiveButton("Groan", new DialogInterface.OnClickListener() {
   					public void onClick(DialogInterface dialog, int which) {
   						Toast.makeText(getApplicationContext(), "Sorry.", Toast.LENGTH_LONG);
   					}
   				}
   		).show();
	  }
	}
}
