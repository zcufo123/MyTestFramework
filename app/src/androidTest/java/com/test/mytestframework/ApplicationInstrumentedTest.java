package com.test.mytestframework;

import android.app.Application;
import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnitRunner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@HiltAndroidTest
public final class ApplicationInstrumentedTest extends AndroidJUnitRunner {

    @Rule
    public HiltAndroidRule rule = new HiltAndroidRule(this);

    @Before
    public void init() {
        rule.inject();
    }

    @Override
    public void callApplicationOnCreate(Application app) {
        super.callApplicationOnCreate(app);
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.test.mytestframework", appContext.getPackageName());
    }
}