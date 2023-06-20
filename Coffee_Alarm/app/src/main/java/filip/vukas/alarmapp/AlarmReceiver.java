package filip.vukas.alarmapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AlarmReceiver", "PRIMLJENOOOO ZA HTTP !!!!");
        HttpHelper rt = new HttpHelper("H");
        rt.start();
    }
}
