package ianfox.betternotifications;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import java.util.Random;


import android.support.annotation.Nullable;

/**
 * Created by Ian on 2015-10-04.
 */
public class BzzzService extends Service {
    public BzzzService() {
    }
    Alarm alarm = new Alarm();
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        alarm.SetAlarm(this);
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class SBinder extends Binder {
        public BzzzService getService() {
            return BzzzService.this;
        }
    }



}
