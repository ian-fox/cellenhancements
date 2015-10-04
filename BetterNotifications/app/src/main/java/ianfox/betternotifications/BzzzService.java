package ianfox.betternotifications;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Vibrator;
import android.app.Notification;
import android.support.annotation.Nullable;
import java.util.Random;


import android.util.Log;

/**
 * Created by Ian on 2015-10-04.
 */
public class BzzzService extends Service {
    public BzzzService() {
    }

    public class SBinder extends Binder {
        public BzzzService getService() {
            return BzzzService.this;
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        Random r = new Random();
        while (true) {
            if (!pm.isScreenOn()){
                v.vibrate(Notification.DEFAULT_VIBRATE);
            }
            sleep(r.nextInt(20000) + 10000);
        }
    }

    public static void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
        }
    }


}
