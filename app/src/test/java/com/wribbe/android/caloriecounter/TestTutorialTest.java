package com.wribbe.android.caloriecounter;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by steff on 3/19/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTutorialTest {

    @Test
    public void TestTutorial_ReturnsTrue() {
        assertThat(TestTutorial.isValidEmail("name@email.com"), is(true));
    }
}
