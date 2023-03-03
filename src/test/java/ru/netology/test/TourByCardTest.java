package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.SQLRequests;
import ru.netology.page.FormFilling;
import ru.netology.page.MainPage;
import ru.netology.page.Responses;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TourByCardTest {

    @BeforeAll
    static void setUpAll() {
    SelenideLogger.addListener("allure", new AllureSelenide());
}

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }


    @Test
    void shouldCheckValidApprovedByCard() {
        MainPage.choiceByCard();
        FormFilling.getApprovedCard();
        FormFilling.checkValidPage();
        Responses.getBankApproval();

        assertEquals("APPROVED", SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckValidDeclinedByCard() {
        MainPage.choiceByCard();
        FormFilling.getDeclinedCard();
        FormFilling.checkValidPage();
        Responses.getBankRefusal();

        assertEquals("DECLINED", SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckInvalidByCard() {
        MainPage.choiceByCard();
        FormFilling.getRandomCard();
        FormFilling.checkInvalidPage();
        Responses.getAllInvalidFields();
    }

    @Test
    void shouldCheckEmptyByCard() {
        MainPage.choiceByCard();
        FormFilling.checkEmptyPage();
        Responses.getEmptyFieldsResponse();
    }

    @Test
    void shouldCheckInvalidMonthAndYearByCard() {
        MainPage.choiceByCard();
        FormFilling.getApprovedCard();
        FormFilling.checkInvalidMonthAndYear();
        Responses.getInvalidMonthAndYearResponse();
    }

    @Test
    void shouldCheckInvalidHolderByCard() {
        MainPage.choiceByCard();
        FormFilling.getDeclinedCard();
        FormFilling.checkInvalidHolder();
        Responses.getInvalidHolder();
    }

    @Test
    void shouldCheckEmptyAndFilledByCard() {
        MainPage.choiceByCard();
        FormFilling.checkEmptyPage();
        Responses.getEmptyFieldsResponse();

        FormFilling.getApprovedCard();
        FormFilling.checkValidPage();
        FormFilling.checkInvalidElementsOnPage();
        Responses.getBankApproval();

        assertEquals("APPROVED", SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckDeletingDataByCard() {
        MainPage.choiceByCard();
        FormFilling.getApprovedCard();
        FormFilling.checkValidPage();
        Responses.getBankApproval();
        FormFilling.checkEmptyInputElements();

        assertEquals("APPROVED", SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckZeroValuesByCard() {
        MainPage.choiceByCard();
        FormFilling.checkPageWithZeroValues();
        Responses.getZeroValuesResponse();
    }

    @Test
    void shouldCheckShortCardNumberByCard() {
        MainPage.choiceByCard();
        FormFilling.checkShortCard();
        Responses.getZeroValuesResponse();
    }
}
