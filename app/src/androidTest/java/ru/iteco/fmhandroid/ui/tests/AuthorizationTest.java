package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.invalidLogin;
import static ru.iteco.fmhandroid.ui.data.Data.invalidPassword;
import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitElement;
import static ru.iteco.fmhandroid.ui.pages.MainPage.LogOutId;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.checkLogOutAndLogOutIfNot;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.logOutIsVisible;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.login;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.loginOrPasswordDoesNotBeEmpty;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.loginOrPasswordIsWrong;

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
public class AuthorizationTest {

    @Before
    public void setUp(){
        checkLogOutAndLogOutIfNot();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);


    @Test
    public void validLoginAndPasswordAuthorizationTest() {
        login(validLogin, validPassword);
        waitElement(LogOutId);
        logOutIsVisible();
    }

    @Test
    public void invalidLoginAuthorizationTest() {
        login(invalidLogin, validPassword);
        loginOrPasswordIsWrong();
    }

    @Test
    public void invalidPasswordAuthorizationTest() {
        login(validLogin, invalidPassword);
        loginOrPasswordIsWrong();
    }

    @Test
    public void emptyLoginAndPasswordAuthorizationTest() {
        login("","");
        loginOrPasswordDoesNotBeEmpty();
    }

}
