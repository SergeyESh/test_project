package ru.iteco.fmhandroid.ui.pages;

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
import static ru.iteco.fmhandroid.ui.pages.NewsPage.categoryNewsField;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.checkboxActive;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.checkboxNotActive;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.dateEndPublish;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.dateStartPublish;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.filterButton;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.filterNewsButton;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.newsListId;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.sortingNewsButton;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import ru.iteco.fmhandroid.R;

public class EditingNewsPage {

    public static ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    public static ViewInteraction categoryIconImage = onView(withId(R.id.category_icon_image_view));
    public static ViewInteraction tittleNewsEditing = onView(withId(R.id.news_item_title_text_view));
    public static ViewInteraction datePublishNews = onView(withId(R.id.news_item_publication_date_text_view));
    public static ViewInteraction dateCreateNews = onView(withId(R.id.news_item_create_date_text_view));
    public static ViewInteraction authorNews = onView(withId(R.id.news_item_author_name_text_view));
    public static ViewInteraction statusNews = onView(withId(R.id.news_item_published_text_view));
    public static ViewInteraction deleteNewsButton = onView(withId(R.id.delete_news_item_image_view));
    public static ViewInteraction expandNewsButton = onView(withId(R.id.view_news_item_image_view));
    public static ViewInteraction descriptionNews = onView(withId(R.id.news_item_description_text_view));
    public static ViewInteraction refreshZone = onView(withId(R.id.news_control_panel_swipe_to_refresh));
    public static ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction tittleField = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction dateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction timeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static ViewInteraction statusSwitcher = onView(withId(R.id.switcher));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
    public static ViewInteraction confirmCancelAddingNewsButton = onView(allOf(withId(android.R.id.button1)));
    public static ViewInteraction cancelMessage = onView(withText(R.string.cancellation));
    public static ViewInteraction confirmDeleteNewsButton = onView(allOf(withId(android.R.id.button1)));
    public static int confirmDeleteNewsButtonId = android.R.id.button1;

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
