

import lesson_18.MtsPage;
import lesson_18.TopupPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import static org.junit.jupiter.api.Assertions.*;

@Feature("Форма <онлайн пополнение без комиссии>")
public class MtsTest extends SettingTest {

    @Test
    @Story("Опция <Услуги связи>")
    @DisplayName("Проверка полей формы")
    @Description("Проверка плейсхолдеров в полях формы")
    public void testPlaceHolderContainsCommunicationServiceFields() {
        MtsPage page = new MtsPage(driver);
        page.selectService(MtsPage.communicationService);
        assertAll(() -> assertEquals("Номер телефона", page.getCommunicationServicePhoneNumberPlaceHolder()), () -> assertEquals("Сумма", page.getCommunicationServiceAmountPlaceHolder()), () -> assertEquals("E-mail для отправки чека", page.getCommunicationServiceEmailPlaceHolder()));
        System.out.println("Номер телефона, " + "Сумма, " + "E-mail для отправки чека" + " соответствуют");


    }

    @Test
    @Story("Опция <Домашний интернет>")
    @DisplayName("Проверка полей формы")
    @Description("Проверка плейсхолдеров в полях формы")
    public void testPlaceHolderContainsInternetFields() {
        MtsPage page = new MtsPage(driver);
        page.selectService(MtsPage.internetOption);
        assertAll(() -> assertEquals("Номер абонента", page.getInternetNumberPlaceHolder()), () -> assertEquals("Сумма", page.getInternetAmountPlaceHolder()), () -> assertEquals("E-mail для отправки чека", page.getInternetEmailPlaceHolder()));

    }

    @Test
    @Story("Опция <Рассрочка>")
    @DisplayName("Проверка полей формы")
    @Description("Проверка плейсхолдеров в полях формы")
    public void testPlaceHolderContainsInstallmentFields() {
        MtsPage page = new MtsPage(driver);
        page.selectService(MtsPage.installmentOption);
        assertAll(() -> assertEquals("Номер счета на 44", page.getInstallmentAccountNumberPlaceHolder()), () -> assertEquals("Сумма", page.getInstallmentAmountPlaceHolder()), () -> assertEquals("E-mail для отправки чека", page.getInstallmentEmailPlaceHolder()));
        System.out.println("Номер счета на 44, " + "Сумма, " + "E-mail для отправки чека" + " соответствуют");

    }

    @Test
    @Story("Опция <Задолженность>")
    @DisplayName("Проверка полей формы")
    @Description("Проверка плейсхолдеров в полях формы")

    public void testPlaceHolderContainsArrearsFields() {
        MtsPage page = new MtsPage(driver);
        page.selectService(MtsPage.arrearsOption);
        assertAll(() -> assertEquals("Номер счета на 2073", page.getArrearsAccountNumberPlaceHolder()), () -> assertEquals("Сумма", page.getArrearsAmountPlaceHolder()), () -> assertEquals("E-mail для отправки чека", page.getArrearsEmailPlaceHolder()));
    }

    @Test
    @Story("Форма оплаты")
    @DisplayName("Проверка полей формы")
    @Description("Проверка плейсхолдеров в полях формы")

    public void testCheckoutLabels() {
        MtsPage page = new MtsPage(driver);
        page.fillPaymentForm("297777777", "99,99", "nikolay@yandex.ru");
        page.clickContinueButton();
        TopupPage iframeCheckoutPage = new TopupPage(driver);
        iframeCheckoutPage.switchToIframe();
        String cardNumberFieldLabelMessage = iframeCheckoutPage.getCardNumberFieldLabel();
        String expirationDateFieldLabelMessage = iframeCheckoutPage.getExpirationDateFieldLabel();
        String cvcFieldLabelMessage = iframeCheckoutPage.getCvcFieldLabel();
        String cardHolderFieldLabelMessage = iframeCheckoutPage.getCardHolderFieldLabel();
        assertAll(() -> assertEquals("Номер карты", cardNumberFieldLabelMessage, "Текст не является <Номер карты>"), () -> assertEquals("Срок действия", expirationDateFieldLabelMessage, "Текст не является <Срок действия>"), () -> assertEquals("CVC", cvcFieldLabelMessage, "Текст не является <CVC>"), () -> assertEquals("Имя держателя (как на карте)", cardHolderFieldLabelMessage, "Текст не является <Имя держателя (как на карте)>"));
    }

    @Test
    @Story("Форма оплаты")
    @DisplayName("Проверка корректности отображения данных в форме")
    @Description("Проверка корректности отображения суммы (в том числе на кнопке), номера телефона")

    public void testCheckoutFields() {
        MtsPage page = new MtsPage(driver);
        String number = "297777777";
        String amount = "100.00";
        String email = "nikolay@yandex.ru";
        page.fillPaymentForm(number, amount, email);
        page.clickContinueButton();
        TopupPage iframeCheckoutPage = new TopupPage(driver);
        iframeCheckoutPage.switchToIframe();
        String amountTitle = iframeCheckoutPage.getAmountTitle();
        String communicationServiceSummary = iframeCheckoutPage.getServiceSummary();
        String submitButtonText = iframeCheckoutPage.getSubmitButtonText();
        assertAll(() -> assertEquals(amount + " BYN", amountTitle, "Текст не является <введенная сумма> + BYN"), () -> assertEquals("Оплата: " + MtsPage.communicationService + " Номер:375" + number, communicationServiceSummary), () -> assertEquals("Оплатить " + amount + " BYN", submitButtonText, "Сумма на кнопке не совпадает с введенной"));
    }

    @Test
    @Story("Форма оплаты")
    @DisplayName("Проверка наличия иконок платежных систем")
    @Description("Проверка наличия иконок платежных систем")

    public void testCheckoutLogos() {
        MtsPage page = new MtsPage(driver);
        page.fillPaymentForm("297777777", "100", "nikolay@yandex.ru");
        page.clickContinueButton();
        TopupPage iframeCheckoutPage = new TopupPage(driver);
        iframeCheckoutPage.switchToIframe();
        for (WebElement element : iframeCheckoutPage.getCheckoutStaticPaymentLogos()) {
            assertTrue(element.isDisplayed(), element + " не отображается!");
            String src = element.getAttribute("src");
            assertNotNull(src, "Логотип не имеет src");
            assertFalse(src.isEmpty(), "У логотипа пустой src");
        }

        for (WebElement element : iframeCheckoutPage.getCheckoutPaymentRandomLogos()) {
            assertTrue(element.isDisplayed(), element + " не отображается!");
            String src = element.getAttribute("src");
            assertNotNull(src, "Логотип не имеет src");
            assertFalse(src.isEmpty(), "У логотипа пустой src");
        }
        assertEquals(2, iframeCheckoutPage.getCheckoutPaymentRandomLogos().size(), "Количество динамичных логотипов не равно 2!");
        assertEquals(3, iframeCheckoutPage.getCheckoutStaticPaymentLogos().size(), "Количество статичных логотипов не равно 3!");
    }
}
