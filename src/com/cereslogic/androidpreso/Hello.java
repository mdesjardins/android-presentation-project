package com.cereslogic.androidpreso;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Hello extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
    }

    public void deliverBacon(View view) {
    		Log.i("DemoApp", "TODO: Figure Out How To Deliver Bacon!");
    }
}