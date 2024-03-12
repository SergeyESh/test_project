package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.data.DataHelper.*;
import static ru.iteco.fmhandroid.ui.pages.AuthorizationPage.*;
import static ru.iteco.fmhandroid.ui.pages.MainPage.*;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.*;

import androidx.test.espresso.ViewInteraction;
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
public class NewsPageTest {

    @Before
    public void setUp() {
        checkLogOutAndLogOutIfNot();
        goToNewsPage();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    ViewInteraction recyclerView = getRecyclerViewAndScrollToFirstPosition();
    int heightBeforeClick = getHeightBeforeClick(recyclerView);
    int heightAfterClick = getHeightAfterClick(recyclerView);

    @Test
    public void expandNewsTest() {      //Развернуть новость
        waitElement(newsListId);
        clickFirstItem(recyclerView);
        checkHeightAfterClick(heightBeforeClick, heightAfterClick);
    }

    @Test
    public void collapseNewsTest() {        //Свернуть новость
        waitElement(newsListId);
        doubleClickFirstItem(recyclerView);
        checkHeightAfterDoubleClick(heightBeforeClick, heightAfterClick);
    }

    @Test
    public void filterNewsByDateTest() {        //Фильтрация новостей по дате
        goToNewsEditingPage();
        String expectedDate = addingNewsAndReturnPublishDate();
        goToNewsPage();
        filterNewsByDateStep(expectedDate);
        int itemCount = getItemCount();
        checkPublishDateNews(itemCount, expectedDate);
    }

}
