package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.checkToast;
import static ru.iteco.fmhandroid.ui.data.DataHelper.isLogIn;
import static ru.iteco.fmhandroid.ui.data.DataHelper.isLogOut;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitElement;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitUntilVisible;
import static ru.iteco.fmhandroid.ui.pages.AuthorizationPage.enterButton;
import static ru.iteco.fmhandroid.ui.pages.AuthorizationPage.fieldLogin;
import static ru.iteco.fmhandroid.ui.pages.AuthorizationPage.fieldPassword;
import static ru.iteco.fmhandroid.ui.pages.MainPage.LogOutId;
import static ru.iteco.fmhandroid.ui.pages.MainPage.logOutButton;

import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;

public class AuthorizationSteps {

    @Step("Ввод логина и пароля.")
    public static void login(String login, String password){
        Allure.step("Вводим логин и пароль: " + login + password);
        waitElement(AuthorizationPage.enterButtonId);
        fieldLogin.perform(replaceText(login));
        fieldPassword.perform(replaceText(password));
        enterButton.check(matches(isDisplayed())).perform(click());
    }

    public static void logOut() {
        onView(withId(LogOutId)).perform(click());
        onView(withId(android.R.id.title)).check(matches(isDisplayed()));
        onView(withId(android.R.id.title)).perform(click());
    }

    public static void checkLogInAndLogInIfNot() {
        if (isLogIn()) {
            login(validLogin, validPassword);
        }
    }

    public static void checkLogOutAndLogOutIfNot() {
        if (isLogOut()) {
            logOut();
        }
    }

    public static void logOutIsVisible() {
        logOutButton.check(matches(isDisplayed()));
    }

    public static void loginOrPasswordDoesNotBeEmpty() {
        waitUntilVisible(checkToast(R.string.empty_login_or_password, true));
    }

    public static void loginOrPasswordIsWrong() {
        waitUntilVisible(checkToast(R.string.error, true));
    }
}
