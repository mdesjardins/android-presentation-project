package com.cereslogic.androidpreso;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ArrayAdapter;

public class BaconTreats extends ListActivity {	
	
	@Override
  protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      //setContentView(R.layout.treat_list); we don't need this, ListActivity provides a default
      
      ArrayAdapter<String> aa = new ArrayAdapter<String>(this,R.layout.empty);
      aa.add(getResources().getString(R.string.bacon_plain));
      aa.add(getResources().getString(R.string.bacon_and_eggs));
      aa.add(getResources().getString(R.string.bacon_bits));
      aa.add(getResources().getString(R.string.bacon_cheeseburger));
      aa.add(getResources().getString(R.string.bacon_chewing_gum));
      aa.add(getResources().getString(R.string.bacon_ice_cream));
      aa.add(getResources().getString(R.string.bacon_lettuce_tomato_sandwich));
      aa.add(getResources().getString(R.string.bacon_lollipop));
      
      setListAdapter(aa);
  }
}
