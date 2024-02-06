package ru.iteco.fmhandroid.ui.data;

import static ru.iteco.fmhandroid.ui.data.DataHelper.getStringFromResource;

import net.datafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ru.iteco.fmhandroid.R;

public class Data {

    private static Faker faker = new Faker();
    private static LocalDateTime date = LocalDateTime.now();
    private static DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("hh:mm");

    public static final String validLogin = "login2";
    public static final String validPassword = "password2";
    public static final String invalidLogin = "login";
    public static final String invalidPassword = "password";

    public static final String urlPrivacyPolicy = "https://vhospice.org/#/privacy-policy/";
    public static final String urlTermsOfUse = "https://vhospice.org/#/terms-of-use";

    public static final String categoryNotification = "Объявление";
    public static final String categoryBirthday = "День рождения";
    public static final String categorySalary = "Зарплата";
    public static final String categoryUnion = "Профсоюз";
    public static final String categoryHoliday = "Праздник";
    public static final String categoryMassage = "Массаж";
    public static final String categoryGratitude = "Благодарность";
    public static final String categoryHelp = "Нужна помощь";
    public static final String tittleNews = "Tittle_" + faker.number().numberBetween(1, 9999999);
    public static final String newTittleNews = "NewTittle_" + faker.number().numberBetween(1, 9999999);
    public static final String dateNews = formatterDate.format(date);
    public static final String dateNewsNextDay = formatterDate.format(date.plusDays(1));
    public static final String dateNewsPreviousDay = formatterDate.format(date.minusDays(1));
    public static final String timeNews = formatterTime.format(date);
    public static final String newTimeNews = formatterTime.format(date.plusHours(1));
    public static final String descriptionNews = "Description" + faker.simpsons().toString();
    public static final String newDescriptionNews = "NewDescription" + faker.simpsons().toString();
    public static final String statusActive = getStringFromResource(R.string.news_control_panel_active);
    public static final String statusNotActive = getStringFromResource(R.string.news_control_panel_not_active);

}
