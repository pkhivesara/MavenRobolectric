package com.demo.libraries;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    Activity activity;

    @Before
    public void before() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void sampleUnitTest() throws Exception {

        assertNotNull(activity);

        Button clickButton = (Button) activity.findViewById(R.id.buttonClick);
        assertThat(clickButton, CoreMatchers.notNullValue());

        TextView textView = (TextView) activity.findViewById(R.id.textViewActivity);
        assertThat(textView, CoreMatchers.notNullValue());

        clickButton.performClick();

        int clickButtonVisibility = clickButton.getVisibility();
        int textViewVisibility = textView.getVisibility();

        assertThat(clickButtonVisibility, is(8));
        assertThat(textViewVisibility, is(8));

        String text = textView.getText().toString();
        assertThat(text, equalTo("This is the first activity"));
    }
}