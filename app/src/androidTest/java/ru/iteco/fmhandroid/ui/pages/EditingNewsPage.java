package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.ViewInteraction;

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

}
