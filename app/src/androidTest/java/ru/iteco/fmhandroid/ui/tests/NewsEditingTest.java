package ru.iteco.fmhandroid.ui.tests;

import static org.junit.Assert.assertEquals;
import static ru.iteco.fmhandroid.ui.data.Data.categorySalary;
import static ru.iteco.fmhandroid.ui.data.Data.dateNews;
import static ru.iteco.fmhandroid.ui.data.Data.descriptionNews;
import static ru.iteco.fmhandroid.ui.data.Data.newDescriptionNews;
import static ru.iteco.fmhandroid.ui.data.Data.newTimeNews;
import static ru.iteco.fmhandroid.ui.data.Data.newTittleNews;
import static ru.iteco.fmhandroid.ui.data.Data.timeNews;
import static ru.iteco.fmhandroid.ui.data.Data.tittleNews;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getFirstDateAfterSortingNewsPage;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getFirstDateBeforeSortingNewsPage;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getItemCount;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getLastDateAfterSortingNewsPage;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getLastDateBeforeSortingNewsPage;
import static ru.iteco.fmhandroid.ui.steps.AuthorizationSteps.checkLogInAndLogInIfNot;
import static ru.iteco.fmhandroid.ui.steps.NavigationSteps.goToNewsEditingPage;
import static ru.iteco.fmhandroid.ui.steps.NavigationSteps.goToNewsPage;

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

public class NewsEditingTest {

    @Before
    public void setUp() {
        checkLogInAndLogInIfNot();
        goToNewsPage();
        goToNewsEditingPage();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> myActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);


    @Test
    public void testSortingNewsInEditingNews() {                                         //Сортировка новостей в разделе редактирования новостей
//        int itemCount = getItemCount();
//        String firstDateBeforeSorting = getFirstDateBeforeSortingNewsPage();
//        NewsEditingPageSteps.scrollNewsToLastPosition(itemCount - 1);
//        String lastDateBeforeSorting = getLastDateBeforeSortingNewsPage(itemCount - 1);
//        sortingNews();
//        NewsEditingPageSteps.scrollNewsToFirstPosition();
//        String firstDateAfterSorting = getFirstDateAfterSortingNewsPage();
//        NewsEditingPageSteps.scrollNewsToLastPosition(itemCount - 1);
//        String lastDateAfterSorting = getLastDateAfterSortingNewsPage(itemCount - 1);
//        assertEquals(firstDateBeforeSorting, lastDateAfterSorting);
//        assertEquals(lastDateBeforeSorting, firstDateAfterSorting);
    }

    @Test
    public void testAddingNews() {                                                       //Добавление новости
//        addNews(categorySalary,tittleNews,dateNews,timeNews,descriptionNews);
//        NewsEditingPageSteps.scrollToNewsWithTittleAndClick();
//        NewsEditingPageSteps.editingNews();
//        NewsEditingPageSteps.checkAttributesNews();
    }

    @Test
    public void testFilterNewsByStatusActive() {                                         //Фильтрация новостей по статусу Активна
//        NewsEditingPageSteps.filterNewsByStatusActive();
//        int itemCount = NewsEditingPageSteps.getItemCount();
//        NewsEditingPageSteps.isStatusActive(itemCount);
    }

    @Test
    public void testFilterNewsByStatusNotActive() {                                     //Фильтрация новостей по статусу Неактивна
//        NewsEditingPageSteps.filterNewsByStatusNotActive();
//        int itemCount = NewsEditingPageSteps.getItemCount();
//        NewsEditingPageSteps.isStatusNotActive(itemCount);
    }

    @Test
    public void testFilterNewsByStatusActiveAndDatePublish() {                          //Фильтрация новостей по статусу Активна и дате публикации
//        NewsEditingPageSteps.addingNews();
//        NewsEditingPageSteps.filterNewsByStatusActiveAndPublishDate();
//        int itemCount = NewsEditingPageSteps.getItemCount();
//        NewsEditingPageSteps.isStatusActiveAndPublishDateEqualsFilterDate(itemCount);
    }

    @Test
    public void testRefusalAddingNewsWithEmptyFieldCategory() {                         //Отказ в добавление новости при незаполненном поле Категория
//        NewsEditingPageSteps.addNewsWithEmptyFieldCategory();
//        NewsEditingPageSteps.neverFieldsDoesntBeEmptyMessage();
    }

    @Test
    public void testRefusalAddingNewsWithEmptyFieldTittle() {                        //Отказ в добавление новости при незаполненном поле Заголовок
//        NewsEditingPageSteps.addNewsWithEmptyFieldTittle();
//        NewsEditingPageSteps.neverFieldsDoesntBeEmptyMessage();
    }

    @Test
    public void testRefusalAddingNewsWithEmptyFieldDate() {                         //Отказ в добавление новости при незаполненном поле Дата
//        NewsEditingPageSteps.addNewsWithEmptyFieldDate();
//        NewsEditingPageSteps.neverFieldsDoesntBeEmptyMessage();
    }

    @Test
    public void testRefusalAddingNewsWithEmptyFieldTime() {                         //Отказ в добавление новости при незаполненном поле Время
//        NewsEditingPageSteps.addNewsWithEmptyFieldTime();
//        NewsEditingPageSteps.neverFieldsDoesntBeEmptyMessage();
    }

    @Test
    public void testRefusalAddingNewsWithEmptyFieldDescription() {                  //Отказ в добавление новости при незаполненном поле Описание
//        NewsEditingPageSteps.addNewsWithEmptyFieldDescription();
//        NewsEditingPageSteps.neverFieldsDoesntBeEmptyMessage();
    }

    @Test
    public void testCancelAddingNewsWithPressCancel() {                             //Отмена добавление новости при нажатии кнопки Отмена
//        NewsEditingPageSteps.fillingAllFieldsNews();
//        NewsEditingPageSteps.pressCancelButton();
//        NewsEditingPageSteps.confirmCancelAddingNews();
//        BaseSteps.pressBack();
//        int itemCount = NewsEditingPageSteps.getItemCount();
//        NewsEditingPageSteps.isNewsNotCreated(itemCount);
    }

}
