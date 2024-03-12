package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertEquals;
import static ru.iteco.fmhandroid.ui.data.Data.*;
import static ru.iteco.fmhandroid.ui.data.Data.descriptionNews;
import static ru.iteco.fmhandroid.ui.data.DataHelper.*;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.*;

import androidx.test.espresso.ViewInteraction;

import org.junit.Assert;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.data.DataHelper;

public class NewsPage {

    public static ViewInteraction sortingNewsButton = onView(withId(R.id.sort_news_material_button));
    public static ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));
    public static ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction tittleText = onView(withId(R.id.news_item_title_text_view));
    public static ViewInteraction descriptionText = onView(withId(R.id.news_item_description_text_view));
    public static ViewInteraction filterNewsTittle = onView(withId(R.id.filter_news_title_text_view));
    public static ViewInteraction categoryNewsButton = onView(allOf(withId(R.id.text_input_end_icon), withContentDescription("Show dropdown menu")));
    public static ViewInteraction categoryNewsField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction dateStartPublish = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public static ViewInteraction dateEndPublish = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public static ViewInteraction filterButton = onView(withId(R.id.filter_button));
    public static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    public static ViewInteraction checkboxActive = onView(withId(R.id.filter_news_active_material_check_box));
    public static ViewInteraction checkboxNotActive = onView(withId(R.id.filter_news_inactive_material_check_box));


    public static int newsListId = R.id.news_list_recycler_view;





    public static String getFirstDateBeforeSortingNewsPage() {          //Получаем дату первой новости из списка до сортировки
        String firstDateBeforeSorting = getTextFromNews(R.id.news_item_date_text_view, 0);
        return firstDateBeforeSorting;
    }

    public static String getLastDateBeforeSortingNewsPage(int position) {       //Получаем дату последней новости из списка до сортировки
        String lastDateBeforeSorting = getTextFromNews(R.id.news_item_date_text_view, position);
        return lastDateBeforeSorting;
    }

    public static String getFirstDateAfterSortingNewsPage() {                   //Получаем дату первой новости из списка после сортировки
        String firstDateBeforeSorting = getTextFromNews(R.id.news_item_date_text_view, 0);
        return firstDateBeforeSorting;
    }

    public static String getLastDateAfterSortingNewsPage(int position) {        //Получаем дату последней новости из списка после сортировки
        String lastDateBeforeSorting = getTextFromNews(R.id.news_item_date_text_view, position);
        return lastDateBeforeSorting;
    }

    public static ViewInteraction getRecyclerViewAndScrollToFirstPosition() {       //Получаем recyclerView для раздела Новости и прокручиваем до его первой позиции
        ViewInteraction recyclerView = onView(withId(R.id.news_list_recycler_view));
        return recyclerView;
    }

    public static int getHeightBeforeClick(ViewInteraction recyclerView) {      //Получаем высоту первого элемента списка до клика
        int[] heightBeforeClick = {0};
        recyclerView.perform(new DataHelper.GetHeightAfterClickViewAction(heightBeforeClick));
        return heightBeforeClick[0];
    }

    public static void clickFirstItem(ViewInteraction recyclerView) {       //Кликаем на первом элементе списка, чтобы элемент развернулся
        recyclerView.perform(actionOnItemAtPosition(0, click()));
    }

    public static int getHeightAfterClick(ViewInteraction recyclerView) {       //Получаем высоту первого элемента списка после клика
        int[] heightAfterClick = {0};
        recyclerView.perform(new DataHelper.GetHeightAfterClickViewAction(heightAfterClick));
        return heightAfterClick[0];
    }

    public static void checkHeightAfterClick(int heightBeforeClick, int heightAfterClick) {     //Проверяем, что высота первого элемента списка увеличилась после клика
        Assert.assertTrue(heightBeforeClick < heightAfterClick);
    }

    public static void doubleClickFirstItem(ViewInteraction recyclerView) {     //Кликаем дважды на первом элементе списка, чтобы элемент развернулся и свернулся
        recyclerView.perform(actionOnItemAtPosition(0, doubleClick()));
    }

    public static void checkHeightAfterDoubleClick(int heightBeforeClick, int heightAfterClick) {       //Проверяем, что высота первого элемента списка осталась той же после двойного клика
        assertEquals(heightBeforeClick, heightAfterClick);
    }

    public static void filterNewsByDateStep(String date) {      //Производим фильтрацию новостей по дате
        filterNewsByDate(date, date);
    }

    public static String addingNewsAndReturnPublishDate() {         //Добавляем новость и возвращаем дату публикации
        addNews(categoryUnion, tittleNews, dateNews, timeNews, descriptionNews);
        return dateNews;
    }

    public static void checkPublishDateNews(int itemCount, String expectedDate) {       //Проверяем, что все новости имеют заданную при фильтрации дату публикации
        for (int i = 0; i < itemCount; i++) {
            scrollNews(i);
            String actualDate = getTextFromNews(R.id.news_item_date_text_view, i);
            assertEquals(expectedDate, actualDate);
        }
    }

    public static int getItemCount() {      //Получаем количество элементов в списке новостей
        int itemCount = getRecyclerViewItemCount(newsListId);
        return itemCount;
    }

}
