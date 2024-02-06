package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static ru.iteco.fmhandroid.ui.data.DataHelper.clickChildViewWithId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitElement;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.addNewsButton;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.categoryField;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.confirmDeleteNewsButton;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.confirmDeleteNewsButtonId;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.dateField;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.descriptionField;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.saveButton;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.statusSwitcher;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.timeField;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.tittleField;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.categoryNewsField;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.checkboxActive;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.checkboxNotActive;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.dateEndPublish;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.dateStartPublish;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.filterButton;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.filterNewsButton;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.newsListId;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.sortingNewsButton;

import androidx.test.espresso.contrib.RecyclerViewActions;

import ru.iteco.fmhandroid.R;

public class EditingNewsSteps {

    public static void filterNewsByStatus(boolean active, boolean notActive) {
        filterNewsButton.perform(click());
        if (!active) {
            checkboxActive.perform(click());
        }
        if (!notActive) {
            checkboxNotActive.perform(click());
        }
        filterButton.perform(click());
        waitElement(newsListId);
    }

    public static void filterNewsByCategory(String category) {
        filterNewsButton.perform(click());
        categoryNewsField.perform(replaceText(category));
        filterButton.perform(click());
    }

    public static void filterNewsByStatusAndDate(boolean active, boolean notActive, String startDate, String endDate) {
        filterNewsButton.perform(click());
        if (!active) {
            checkboxActive.perform(click());
        }
        if (!notActive) {
            checkboxNotActive.perform(click());
        }
        dateStartPublish.perform(replaceText(startDate));
        dateEndPublish.perform(replaceText(endDate));
        filterButton.perform(click());
    }

    public static void sortingNews() {
        waitElement(newsListId);
        sortingNewsButton.perform(click());
    }

    public static void filterNewsByDate(String startDate, String endDate) {
        filterNewsButton.perform(click());
        dateStartPublish.perform(replaceText(startDate));
        dateEndPublish.perform(replaceText(endDate));
        filterButton.perform(click());
    }

    public static void addNews(String category, String tittle, String date, String time, String description) {
        addNewsButton.perform(click());
        categoryField.perform(replaceText(category));
        tittleField.perform(replaceText(tittle));
        dateField.perform(replaceText(date));
        timeField.perform(replaceText(time));
        descriptionField.perform(replaceText(description));
        saveButton.perform(click());
    }

    public static void changeNewsAttribute(String newTittle, String newDate, String newTime, String newDescription) {
        tittleField.perform(replaceText(newTittle));
        dateField.perform(replaceText(newDate));
        timeField.perform(replaceText(newTime));
        descriptionField.perform(replaceText(newDescription));
        saveButton.perform(click());
        waitElement(newsListId);
    }

    public static void scrollNews(int i) {
        onView(withId(newsListId))
                .perform(scrollToPosition(i))
                .perform(actionOnItemAtPosition(i, scrollTo()))
                .check(matches(isDisplayed()));
    }

    public static void scrollAndClickToNewsWithTittle(String tittle) {
        waitElement(newsListId);
        onView(withId(newsListId))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollTo(hasDescendant(allOf(withText(tittle)))));
        onView(withId(newsListId))
                .check(matches(isDisplayed()))
                .perform(actionOnItem(hasDescendant(withText(tittle)), click()));
    }

    public static void editNews(String tittle) {
        scrollAndClickToNewsWithTittle(tittle);
        onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(tittle))))
                .perform(clickChildViewWithId(R.id.edit_news_item_image_view));
    }

    public static void changeNewsStatus(String tittle) {
        scrollAndClickToNewsWithTittle(tittle);
        editNews(tittle);
        statusSwitcher.perform(click());
        saveButton.perform(click());
    }

    public static void deleteNews(String tittle) {
        scrollAndClickToNewsWithTittle(tittle);
        onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(tittle))))
                .perform(clickChildViewWithId(R.id.delete_news_item_image_view));
        confirmDelete();
    }

    public static void confirmDelete() {
        waitElement(confirmDeleteNewsButtonId);
        confirmDeleteNewsButton.perform(click());
    }

}
