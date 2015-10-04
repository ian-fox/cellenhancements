package ianfox.betternotifications;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;

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

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        for (int i = 0; i < 100; i++) {
            v.vibrate(500);
            sleep(1000);
        }
        return null;
    }

    public static void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
        }
    }


}
