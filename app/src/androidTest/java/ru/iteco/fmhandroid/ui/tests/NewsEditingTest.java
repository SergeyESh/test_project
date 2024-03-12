package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.pressBack;
import static org.junit.Assert.assertEquals;
import static ru.iteco.fmhandroid.ui.data.Data.*;
import static ru.iteco.fmhandroid.ui.data.Data.descriptionNews;
import static ru.iteco.fmhandroid.ui.pages.AuthorizationPage.*;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.*;
import static ru.iteco.fmhandroid.ui.pages.MainPage.*;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.*;

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

//
//    @Test
//    public void testSortingNewsInEditingNews() {                                         //Сортировка новостей в разделе редактирования новостей
//        int itemCount = getItemCount();
//        String firstDateBeforeSorting = getFirstDateBeforeSortingNewsPage();
//        scrollNewsToLastPosition(itemCount - 1);
//        String lastDateBeforeSorting = getLastDateBeforeSortingNewsPage(itemCount - 1);
//        sortingNews();
//        scrollNewsToFirstPosition();
//        String firstDateAfterSorting = getFirstDateAfterSortingNewsPage();
//        scrollNewsToLastPosition(itemCount - 1);
//        String lastDateAfterSorting = getLastDateAfterSortingNewsPage(itemCount - 1);
//        assertEquals(firstDateBeforeSorting, lastDateAfterSorting);
//        assertEquals(lastDateBeforeSorting, firstDateAfterSorting);
//    }
//
//    @Test
//    public void testAddingNews() {                                                       //Добавление новости
//        addNews(categorySalary,tittleNews,dateNews,timeNews,descriptionNews);
//        scrollToNewsWithTittleAndClick();
//        editingNews();
//        checkAttributesNews();
//    }
//
//    @Test
//    public void testFilterNewsByStatusActive() {                                         //Фильтрация новостей по статусу Активна
//        filterNewsByStatus();
//        int itemCount = getItemCount();
//        isStatusActive(itemCount);
//    }
//
//    @Test
//    public void testFilterNewsByStatusNotActive() {                                     //Фильтрация новостей по статусу Неактивна
//        filterNewsByStatusNotActive();
//        int itemCount = NewsEditingPageSteps.getItemCount();
//        isStatusNotActive(itemCount);
//    }
//
//    @Test
//    public void testFilterNewsByStatusActiveAndDatePublish() {                          //Фильтрация новостей по статусу Активна и дате публикации
//        addNews(categorySalary,tittleNews,dateNews,timeNews,descriptionNews);
//        filterNewsByStatusActiveAndPublishDate();
//        int itemCount = NewsEditingPageSteps.getItemCount();
//        isStatusActiveAndPublishDateEqualsFilterDate(itemCount);
//    }
//
//    @Test
//    public void testRefusalAddingNewsWithEmptyFieldCategory() {                         //Отказ в добавление новости при незаполненном поле Категория
//        addNewsWithEmptyFieldCategory();
//        neverFieldsDoesntBeEmptyMessage();
//    }
//
//    @Test
//    public void testRefusalAddingNewsWithEmptyFieldTittle() {                        //Отказ в добавление новости при незаполненном поле Заголовок
//        addNewsWithEmptyFieldTittle();
//        neverFieldsDoesntBeEmptyMessage();
//    }
//
//    @Test
//    public void testRefusalAddingNewsWithEmptyFieldDate() {                         //Отказ в добавление новости при незаполненном поле Дата
//        addNewsWithEmptyFieldDate();
//        neverFieldsDoesntBeEmptyMessage();
//    }
//
//    @Test
//    public void testRefusalAddingNewsWithEmptyFieldTime() {                         //Отказ в добавление новости при незаполненном поле Время
//        addNewsWithEmptyFieldTime();
//        neverFieldsDoesntBeEmptyMessage();
//    }
//
//    @Test
//    public void testRefusalAddingNewsWithEmptyFieldDescription() {                  //Отказ в добавление новости при незаполненном поле Описание
//        addNewsWithEmptyFieldDescription();
//        neverFieldsDoesntBeEmptyMessage();
//    }
//
//    @Test
//    public void testCancelAddingNewsWithPressCancel() {                             //Отмена добавление новости при нажатии кнопки Отмена
//        fillingAllFieldsNews();
//        pressCancelButton();
//        confirmCancelAddingNews();
//        pressBack();
//        int itemCount = getItemCount();
//        isNewsNotCreated(itemCount);
//    }

}
