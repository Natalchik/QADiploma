package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataGenerator;
import ru.netology.data.SQLRequests;
import ru.netology.page.PaymentPage;


import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static ru.netology.data.DataGenerator.*;
import static ru.netology.data.DataGenerator.emptyCvc;
import static ru.netology.data.SQLRequests.clearTables;

public class TourByCreditTest {
    private PaymentPage paymentPage;

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
        paymentPage = new PaymentPage();
    }
    @AfterEach
    public void cleanTables() {
        clearTables();
    }

    @Test
    void shouldCheckValidApprovedByCreditCard() {
        paymentPage.openCreditCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.shouldHaveSuccessNotification();
        fillOtherFieldsByValidInfo();
        assertEquals("APPROVED", new SQLRequests().getStatusByCredit());
    }

    @Test
    void shouldCheckValidDeclinedCreditCard() {
        paymentPage.openCreditCardPaymentPage();
        paymentPage.fillCardNumberField(declinedCardNumber);
        paymentPage.shouldHaveErrorNotification();
        fillOtherFieldsByValidInfo();
        assertEquals("DECLINED", new SQLRequests().getStatusByCredit());
    }

    @Test
    void shouldCheckInvalidByCreditCard() {
        paymentPage.openCreditCardPaymentPage();
        paymentPage.fillCardNumberField(getRandomCard());
        paymentPage.shouldHaveErrorNotification();
        fillOtherFieldsByValidInfo();
        assertNull(new SQLRequests().getStatusByCredit());
    }

    @Test
    void shouldCheckEmptyByCreditCard() {
        paymentPage.openCreditCardPaymentPage();
        stayAllFieldsEmpty();
        paymentPage.shouldHaveErrorNotificationRequiredField();
        assertNull(new SQLRequests().getStatusByCredit());
    }
    @Test
    void shouldCheckZeroValuesByCreditCard() {
        paymentPage.openCreditCardPaymentPage();
        paymentPage.fillCardNumberField(zeroCard);
        paymentPage.fillMonthField(zeroMonth);
        paymentPage.fillYearField(zeroYear);
        paymentPage.fillHolderField(zeroHolder);
        paymentPage.fillCvcField(DataGenerator.getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotification();
        assertNull(new SQLRequests().getStatusByCredit());
    }

    @Test
    void shouldCheckShortCardNumberByCreditCard() {
        paymentPage.openCreditCardPaymentPage();
        paymentPage.fillCardNumberField(shortCardNumber);
        paymentPage.fillMonthField(DataGenerator.getMonth());
        paymentPage.fillYearField(DataGenerator.getYear(0));
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(DataGenerator.getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationWrongFormat();
        assertNull(new SQLRequests().getStatusByCredit());

    }
    @Test
    void shouldCheckInvalidMonthAndYearByCreditCard() {
        paymentPage.openCreditCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.fillMonthField(invalidMonth);
        paymentPage.fillYearField(invalidYear);
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(DataGenerator.getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationInvalidCard();
        assertNull(new SQLRequests().getStatusByCredit());

    }

    @Test
    void shouldCheckInvalidHolderByCreditCard() {
        paymentPage.openCreditCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.fillMonthField(DataGenerator.getMonth());
        paymentPage.fillYearField(DataGenerator.getYear(0));
        paymentPage.fillHolderField(invalidHolder);
        paymentPage.fillCvcField(DataGenerator.getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationWrongFormat();
        assertNull(new SQLRequests().getStatusByCredit());
    }

    @Test
    void shouldCheckFalseMonthByCreditCard() {
        paymentPage.openCreditCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.fillMonthField(falseMonth);
        paymentPage.fillYearField(DataGenerator.getYear(0));
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(DataGenerator.getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationInvalidCard();
        assertNull(new SQLRequests().getStatusByCredit());
    }

    @Test
    void shouldCheckPastYearByCreditCard() {
        paymentPage.openCreditCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.fillMonthField(DataGenerator.getMonth());
        paymentPage.fillYearField(pastYear);
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(DataGenerator.getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationCardExpired();
        assertNull(new SQLRequests().getStatusByCredit());
    }

    @Test
    void shouldCheckInvalidCvsByCreditCard() {
        paymentPage.openCreditCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.fillMonthField(DataGenerator.getMonth());
        paymentPage.fillYearField(DataGenerator.getYear(0));
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(invalidCvc);
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationWrongFormat();
        assertNull(new SQLRequests().getStatusByCredit());
    }
    private void fillOtherFieldsByValidInfo() {
        paymentPage.fillMonthField(DataGenerator.getMonth());
        paymentPage.fillYearField(DataGenerator.getYear(0));
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(DataGenerator.getRandomValidCvc());
        paymentPage.clickContinueButton();
    }
    private void stayAllFieldsEmpty() {
        paymentPage.fillCardNumberField(emptyCard);
        paymentPage.fillMonthField(emptyMonth);
        paymentPage.fillYearField(emptyYear);
        paymentPage.fillHolderField(emptyHolder);
        paymentPage.fillCvcField(emptyCvc);
        paymentPage.clickContinueButton();
    }

}
