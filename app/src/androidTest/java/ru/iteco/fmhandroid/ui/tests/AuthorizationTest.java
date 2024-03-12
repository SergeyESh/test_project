package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.*;
import static ru.iteco.fmhandroid.ui.data.DataHelper.*;
import static ru.iteco.fmhandroid.ui.pages.AuthorizationPage.*;
import static ru.iteco.fmhandroid.ui.pages.MainPage.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
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
        login(emptyLogin,emptyPassword);
        loginOrPasswordDoesNotBeEmpty();
    }

}
