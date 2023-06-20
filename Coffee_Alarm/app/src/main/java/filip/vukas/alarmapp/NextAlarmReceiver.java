package filip.vukas.alarmapp;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NextAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("NextAlarmReceiver", "primljeno u NextAlarmReceiver");

        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        AlarmManager.AlarmClockInfo nextAlarm = am.getNextAlarmClock();

        if (nextAlarm != null) {
            long triggerTime = nextAlarm.getTriggerTime();
            AlarmHandler alarmHandler = new AlarmHandler(triggerTime, context.getApplicationContext());
        } else {
            Log.d("NextAlarmReceiver", "nothing to see here");
        }
    }
}
