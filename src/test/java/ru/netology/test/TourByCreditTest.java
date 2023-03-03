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

public class TourByCreditTest {
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
    void shouldCheckValidApprovedOnCredit() {
        MainPage.choiceByCredit();
        FormFilling.getApprovedCard();
        FormFilling.checkValidPage();
        Responses.getBankApproval();

        assertEquals("APPROVED", SQLRequests.getStatusOnCredit());
    }

    @Test
    void shouldCheckValidDeclinedOnCredit() {
        MainPage.choiceByCredit();
        FormFilling.getDeclinedCard();
        FormFilling.checkValidPage();
        Responses.getBankRefusal();

        assertEquals("DECLINED", SQLRequests.getStatusOnCredit());
    }

    @Test
    void shouldCheckInvalidOnCredit() {
        MainPage.choiceByCredit();
        FormFilling.getRandomCard();
        FormFilling.checkInvalidPage();
        Responses.getAllInvalidFields();
    }

    @Test
    void shouldCheckEmptyOnCredit() {
        MainPage.choiceByCredit();
        FormFilling.checkEmptyPage();
        Responses.getEmptyFieldsResponse();
    }

    @Test
    void shouldCheckInvalidMonthAndYearOnCredit() {
        MainPage.choiceByCredit();
        FormFilling.getDeclinedCard();
        FormFilling.checkInvalidMonthAndYear();
        Responses.getInvalidMonthAndYearResponse();
    }

    @Test
    void shouldCheckInvalidHolderOnCredit() {
        MainPage.choiceByCredit();
        FormFilling.getDeclinedCard();
        FormFilling.checkInvalidHolder();
        Responses.getInvalidHolder();
    }

    @Test
    void shouldCheckEmptyAndFilledOnCredit() {
        MainPage.choiceByCredit();
        FormFilling.checkEmptyPage();
        Responses.getEmptyFieldsResponse();

        FormFilling.getApprovedCard();
        FormFilling.checkValidPage();
        FormFilling.checkInvalidElementsOnPage();
        Responses.getBankApproval();

        assertEquals("APPROVED", SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckDeletingDataOnCredit() {
        MainPage.choiceByCredit();
        FormFilling.getApprovedCard();
        FormFilling.checkValidPage();
        Responses.getBankApproval();
        FormFilling.checkEmptyInputElements();

        assertEquals("APPROVED", SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckZeroValuesOnCredit() {
        MainPage.choiceByCredit();
        FormFilling.checkPageWithZeroValues();
        Responses.getZeroValuesResponse();
    }

    @Test
    void shouldCheckShortCardNumberOnCredit() {
        MainPage.choiceByCredit();
        FormFilling.checkShortCard();
        Responses.getZeroValuesResponse();
    }
}
