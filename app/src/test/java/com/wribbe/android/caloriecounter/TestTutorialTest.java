package com.wribbe.android.caloriecounter;

import org.junit.Test;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by steff on 3/19/16.
 */
public class TestTutorialTest {

    @Test
    public void TestTutorial_ReturnsTrue() {
        assertThat(TestTutorial.isValidEmail("name@email.com"), is(true));
    }

}
