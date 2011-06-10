package com.cereslogic.androidpreso;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Hello extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void showBaconTreats(View view) {
      Intent intent = new Intent(Intent.ACTION_VIEW);
      intent.setComponent(new ComponentName("com.cereslogic.androidpreso","com.cereslogic.androidpreso.BaconTreats"));
      startActivity(intent);
    }
    
    public void deliverBacon(View view) {
    	ImageView i = (ImageView)findViewById(R.id.bacon_image);
    	if (i.getVisibility() == View.INVISIBLE) {
    		i.setVisibility(View.VISIBLE);
    	} else {
    		i.setVisibility(View.INVISIBLE);
    	}
    }
}