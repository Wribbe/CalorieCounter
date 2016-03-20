package com.wribbe.android.caloriecounter;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by steff on 3/20/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestUIEspresso {

    private String mStringToBeTyped;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        mStringToBeTyped = "Espresso";
    }

    @Test
    public void changeText_sameActivity() {
        // Press button.
        onView(withId(R.id.add_ingredient)).perform(click());
    }

}