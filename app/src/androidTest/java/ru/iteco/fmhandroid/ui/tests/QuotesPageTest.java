package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.pages.AuthorizationPage.*;
import static ru.iteco.fmhandroid.ui.pages.MainPage.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class QuotesPageTest {

    @Before
    public void setUp(){
        checkLogInAndLogInIfNot();
        goToQuotesPage();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);


    @Test
    public void expandQuoteTest() {
    }

    @Test
    public void collapseQuoteTest () {
    }

}
