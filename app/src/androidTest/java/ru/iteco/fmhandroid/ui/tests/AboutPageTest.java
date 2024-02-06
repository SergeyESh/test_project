package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.data.Data.urlPrivacyPolicy;
import static ru.iteco.fmhandroid.ui.data.Data.urlTermsOfUse;
import static ru.iteco.fmhandroid.ui.pages.AboutPage.webPageExistence;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.checkLogInAndLogInIfNot;
import static ru.iteco.fmhandroid.ui.steps.NavigationSteps.goToAboutPage;

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
public class AboutPageTest {

    @Before
    public void setUp(){
        checkLogInAndLogInIfNot();
        goToAboutPage();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void switchingUrlPrivacyPolicyTest() {       //Переход по ссылке "Политика конфиденциальности"
        webPageExistence(urlPrivacyPolicy);
    }

    @Test
    public void switchingUrlTermsOfUseTest() {          //Переход по ссылке "Пользовательское сограшение"
        webPageExistence(urlTermsOfUse);
    }

}
