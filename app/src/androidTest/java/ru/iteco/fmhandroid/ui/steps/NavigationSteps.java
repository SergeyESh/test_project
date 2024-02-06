package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitElement;
import static ru.iteco.fmhandroid.ui.pages.MainPage.aboutButton;
import static ru.iteco.fmhandroid.ui.pages.MainPage.allNewsButton;
import static ru.iteco.fmhandroid.ui.pages.MainPage.allNewsButtonId;
import static ru.iteco.fmhandroid.ui.pages.MainPage.mainMenuButton;
import static ru.iteco.fmhandroid.ui.pages.MainPage.mainMenuButtonId;
import static ru.iteco.fmhandroid.ui.pages.MainPage.newsButton;
import static ru.iteco.fmhandroid.ui.pages.MainPage.quotesButton;
import static ru.iteco.fmhandroid.ui.pages.MainPage.quotesButtonID;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.editNewsButton;

public class NavigationSteps {
    public static void goToNewsPage() {
        waitElement(mainMenuButtonId);
        mainMenuButton.perform(click());
        newsButton.check(matches(isDisplayed()));
        newsButton.perform(click());
    }

    public static void goToNewsPageByAllNewsButton() {
        waitElement(allNewsButtonId);
        allNewsButton.perform(click());
    }

    public static void goToAboutPage() {
        waitElement(mainMenuButtonId);
        mainMenuButton.perform(click());
        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());
    }

    public static void goToQuotesPage() {
        waitElement(quotesButtonID);
        quotesButton.perform(click());
    }

    public static void goToNewsEditingPage() {
        editNewsButton.perform(click());
    }
}
