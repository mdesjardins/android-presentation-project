package com.cereslogic.androidpreso;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class BaconBroadcastReceiver extends BroadcastReceiver {
	private final static int BACONGRAM = 1;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) { 
			Log.i("androidpreso","Found our Event!");
			Bundle bundle = intent.getExtras();

			Object messages[] = (Object[]) bundle.get("pdus");
			SmsMessage smsMessage[] = new SmsMessage[messages.length];
			for (int n = 0; n < messages.length; n++) {
				smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
				String text = smsMessage[n].getMessageBody();
				if (smsMessage[n].getMessageBody().contains("bacon")) {
					notify(context, text);
				}
			}
		}
	}
	
	private void notify(Context context, String text) {
		NotificationManager notificationManager = 
			(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		CharSequence tickerText = "Bacongram received";
		long when = System.currentTimeMillis();
		Notification notification = new Notification(android.R.drawable.alert_light_frame, tickerText, when);
		CharSequence contentTitle = "Bacongram received"; 
		CharSequence contentText = text; 
		Intent notificationIntent = new Intent(); 
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		notificationManager.notify(BaconBroadcastReceiver.BACONGRAM, notification);		
	}
}
