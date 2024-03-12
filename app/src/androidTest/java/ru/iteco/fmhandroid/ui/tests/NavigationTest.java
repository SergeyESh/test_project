package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.pages.AboutPage.*;
import static ru.iteco.fmhandroid.ui.pages.AuthorizationPage.*;
import static ru.iteco.fmhandroid.ui.pages.MainPage.*;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.*;
import static ru.iteco.fmhandroid.ui.pages.QuotesPage.*;

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
public class NavigationTest {

    @Before
    public void setUp(){
        checkLogOutAndLogOutIfNot();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);


    @Test
    public void goToNewsPage() {
        goToNewsPage();
        filterNewsButton.check(matches(isDisplayed()));
    }

    @Test
    public void goToNewsPageByAllNewsButtonTest() {
        goToNewsPageByAllNewsButton();
        filterNewsButton.check(matches(isDisplayed()));
    }

    @Test
    public void goToAboutPageTest() {
        goToAboutPage();
        versionText.check(matches(isDisplayed()));
    }

    @Test
    public void goToQuotesPageTest() {
        goToQuotesPage();
        quoteText.check(matches(isDisplayed()));
    }

 }