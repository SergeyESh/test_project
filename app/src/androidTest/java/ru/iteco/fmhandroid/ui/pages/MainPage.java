package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import static ru.iteco.fmhandroid.ui.data.DataHelper.waitElement;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {

    public static ViewInteraction mainMenuButton = onView(allOf(withId(R.id.main_menu_image_button)));
    public static ViewInteraction newsButton = onView(withText(R.string.news));
    public static ViewInteraction logOutButton = onView(allOf(withId(R.id.authorization_image_button)));
    public static ViewInteraction quotesButton = onView(allOf(withId(R.id.our_mission_image_button)));
    public static ViewInteraction aboutButton = onView(withText(R.string.about));
    public static ViewInteraction allNewsButton = onView(allOf(withId(R.id.all_news_text_view)));
    public static int mainMenuButtonId = R.id.main_menu_image_button;
    public static int allNewsButtonId = R.id.all_news_text_view;
    public static int LogOutId = R.id.authorization_image_button;
    public static int quotesButtonID = R.id.our_mission_image_button;

}
