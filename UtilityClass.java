package com.wentura.pomodoroapp;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.preference.PreferenceManager;

import java.util.concurrent.TimeUnit;

class UtilityClass {

    static void toggleDoNotDisturb(Context context, int mode) {
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        if (sharedPreferences.getBoolean(Constants.DO_NOT_DISTURB_SETTINGS, false)) {
            setRingerMode(context, mode);
        }
    }

    private static void setRingerMode(Context context, int mode) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (notificationManager != null && notificationManager.isNotificationPolicyAccessGranted()) {
            AudioManager audioManager = context.getSystemService(AudioManager.class);
            if (audioManager != null) {
                audioManager.setRingerMode(mode);
            }
        }
    }

    static String formatTime(Context context, long milliseconds) {
        return String.format(context.getString(R.string.timeFormat),
                TimeUnit.MILLISECONDS.toMinutes(milliseconds),
                TimeUnit.MILLISECONDS.toSeconds(milliseconds % 60000));
    }
}