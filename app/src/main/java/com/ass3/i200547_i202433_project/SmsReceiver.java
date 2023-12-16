package com.ass3.i200547_i202433_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] smsObj = (Object[]) bundle.get("pdus");

        for(Object obj : smsObj){
            SmsMessage smsMsg = SmsMessage.createFromPdu((byte[]) obj);
            String num = smsMsg.getDisplayOriginatingAddress();
            String msg = smsMsg.getDisplayMessageBody();
            Log.d("Message: ", "Num: " + num + ", Msg: " + msg);

            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage("+9212345678900", null, "Hello", null, null);

        }
    }
}


//open the permissions first before running the app, the sms permissions should
//be set to 'Allow'