package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.data.DataHelper.waitElement;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.addingNewsAndReturnPublishDate;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.checkHeightAfterClick;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.checkHeightAfterDoubleClick;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.checkPublishDateNews;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.clickFirstItem;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.doubleClickFirstItem;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.filterNewsByDateStep;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getHeightAfterClick;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getHeightBeforeClick;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getItemCount;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getRecyclerViewAndScrollToFirstPosition;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.newsListId;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.checkLogOutAndLogOutIfNot;
import static ru.iteco.fmhandroid.ui.steps.NavigationSteps.goToNewsEditingPage;
import static ru.iteco.fmhandroid.ui.steps.NavigationSteps.goToNewsPage;

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
