    package filip.vukas.alarmapp;

    import android.app.AlarmManager;
    import android.app.PendingIntent;
    import android.content.Context;
    import android.content.Intent;
    import android.util.Log;

    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Locale;

    public class AlarmHandler {
        int time;
        long triggerTime;
        private Context context;

        public AlarmHandler(long time, Context context) {
            triggerTime = time - 10000;
            this.context = context;
            String nextAlarmDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date(triggerTime));

            Log.d("AlarmHandler", "AlarmHandler: " + nextAlarmDate);

            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

            Intent intent = new Intent(context, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);

            Log.d("AlarmHandler", "Trigger time: " + String.valueOf(triggerTime));
            am.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
        }
    }
