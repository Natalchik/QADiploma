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
import static ru.netology.data.SQLRequests.clearTables;

public class TourByCardTest {
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
    void shouldCheckValidApprovedByCard() {
        paymentPage.openCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.shouldHaveSuccessNotification();
        fillOtherFieldsByValidInfo();
        assertEquals("APPROVED", SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckValidDeclinedCard() {
        paymentPage.openCardPaymentPage();
        paymentPage.fillCardNumberField(declinedCardNumber);
        paymentPage.shouldHaveErrorNotification();
        fillOtherFieldsByValidInfo();
        assertEquals("DECLINED", SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckInvalidByCard() {
        paymentPage.openCardPaymentPage();
        paymentPage.fillCardNumberField(getRandomCard());
        paymentPage.shouldHaveErrorNotification();
        fillOtherFieldsByValidInfo();
        assertNull(SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckEmptyByCard() {
        paymentPage.openCardPaymentPage();
        stayAllFieldsEmpty();
        paymentPage.shouldHaveErrorNotificationRequiredField();
        assertNull(SQLRequests.getStatusByCard());
    }
    @Test
    void shouldCheckZeroValuesByCard() {
        paymentPage.openCardPaymentPage();
        paymentPage.fillCardNumberField(zeroCard);
        paymentPage.fillMonthField(zeroMonth);
        paymentPage.fillYearField(zeroYear);
        paymentPage.fillHolderField(zeroHolder);
        paymentPage.fillCvcField(getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotification();
        assertNull(SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckShortCardNumberByCard() {
        paymentPage.openCardPaymentPage();
        paymentPage.fillCardNumberField(shortCardNumber);
        paymentPage.fillMonthField(DataGenerator.getMonth());
        paymentPage.fillYearField(DataGenerator.getYear(0));
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationWrongFormat();
        assertNull(SQLRequests.getStatusByCard());

    }
    @Test
    void shouldCheckInvalidMonthAndYearByCard() {
        paymentPage.openCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.fillMonthField(invalidMonth);
        paymentPage.fillYearField(invalidYear);
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationInvalidCard();
        assertNull(SQLRequests.getStatusByCard());

    }

    @Test
    void shouldCheckInvalidHolderByCard() {
        paymentPage.openCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.fillMonthField(DataGenerator.getMonth());
        paymentPage.fillYearField(DataGenerator.getYear(0));
        paymentPage.fillHolderField(invalidHolder);
        paymentPage.fillCvcField(getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationWrongFormat();
        assertNull(SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckFalseMonthByCard() {
        paymentPage.openCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.fillMonthField(falseMonth);
        paymentPage.fillYearField(DataGenerator.getYear(0));
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationInvalidCard();
        assertNull(SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckPastYearByCard() {
        paymentPage.openCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.fillMonthField(DataGenerator.getMonth());
        paymentPage.fillYearField(pastYear);
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(getRandomValidCvc());
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationCardExpired();
        assertNull(SQLRequests.getStatusByCard());
    }

    @Test
    void shouldCheckInvalidCvsByCard() {
        paymentPage.openCardPaymentPage();
        paymentPage.fillCardNumberField(approvedCardNumber);
        paymentPage.fillMonthField(DataGenerator.getMonth());
        paymentPage.fillYearField(DataGenerator.getYear(0));
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(invalidCvc);
        paymentPage.clickContinueButton();
        paymentPage.shouldHaveErrorNotificationWrongFormat();
        assertNull(SQLRequests.getStatusByCard());
    }
    private void fillOtherFieldsByValidInfo() {
        paymentPage.fillMonthField(DataGenerator.getMonth());
        paymentPage.fillYearField(DataGenerator.getYear(0));
        paymentPage.fillHolderField(DataGenerator.getRandomValidHolder());
        paymentPage.fillCvcField(getRandomValidCvc());
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
