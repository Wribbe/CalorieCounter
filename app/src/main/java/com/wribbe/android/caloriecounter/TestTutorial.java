package com.wribbe.android.caloriecounter;

import android.content.Context;

/**
 * Created by steff on 3/19/16.
 */
public class TestTutorial {

    private static Context myContext;

    public TestTutorial(Context context) {
        myContext = context;
    };

    public static boolean isValidEmail(String email) {
        return true;
    }

    public static String getIngredientFlagName() {
        return myContext.getString(R.string.ingredient_flag_name);
    }
}
