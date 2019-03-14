package com.davidkaluta.bricks;

import android.content.Context;
import android.content.SharedPreferences;

public class Saver {
    public static int getHighScore(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_file_key),
            Context.MODE_PRIVATE);
        int defaultValue = -1;
        int highScore = sharedPref.getInt(context.getString(
        R.string.saved_high_score_key),
         defaultValue);
        return highScore;
    }

    public static void setHighScore(Context context, int highScore) {
        SharedPreferences sharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_file_key),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(context.getString(R.string.saved_high_score_key), highScore);
        editor.commit();
    }
}
