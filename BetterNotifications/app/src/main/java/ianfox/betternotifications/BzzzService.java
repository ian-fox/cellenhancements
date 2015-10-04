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
public class BzzzService extends IntentService {
    public BzzzService() {
        super("Bzzz");
    }

    public class SBinder extends Binder {
        public BzzzService getService() {
            return BzzzService.this;
        }
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        Random r = new Random();
        while (true) {
            if (!pm.isScreenOn()){
                v.vibrate(1000);
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
