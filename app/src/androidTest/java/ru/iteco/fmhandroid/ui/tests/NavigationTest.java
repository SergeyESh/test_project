package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.pages.AboutPage.versionText;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.filterNewsButton;
import static ru.iteco.fmhandroid.ui.pages.QuotesPage.quoteText;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.checkLogOutAndLogOutIfNot;
import static ru.iteco.fmhandroid.ui.steps.NavigationSteps.goToAboutPage;
import static ru.iteco.fmhandroid.ui.steps.NavigationSteps.goToNewsPageByAllNewsButton;
import static ru.iteco.fmhandroid.ui.steps.NavigationSteps.goToQuotesPage;

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