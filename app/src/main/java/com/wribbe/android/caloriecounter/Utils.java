package com.wribbe.android.caloriecounter;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by steff on 3/16/16.
 */
public class Utils {

    public static void toast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
