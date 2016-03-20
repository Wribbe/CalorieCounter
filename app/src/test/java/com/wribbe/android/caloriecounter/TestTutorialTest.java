package com.wribbe.android.caloriecounter;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
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

    private static final String FAKE_STRING = "HELLO WORLD";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LoacalizedString() {
        // Given a mocked Context injected into the object under test...
        when(mMockContext.getString(R.string.ingredient_flag_name)).thenReturn(FAKE_STRING);

        TestTutorial myObjectUnderTest = new TestTutorial(mMockContext);

        String result = myObjectUnderTest.getIngredientFlagName();

        assertThat(result, is(FAKE_STRING));
    }
}
