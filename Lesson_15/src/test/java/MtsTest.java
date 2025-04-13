

import lesson_15.MtsPage;
import lesson_15.TopupPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest extends SettingTest {

    @Test
    public void testPlaceHolderContainsCommunicationServiceFields() {
        MtsPage page = new MtsPage(driver);
        page.selectService(MtsPage.communicationService);
        assertAll(() -> assertEquals("Номер телефона", page.getCommunicationServicePhoneNumberPlaceHolder()), () -> assertEquals("Сумма", page.getCommunicationServiceAmountPlaceHolder()), () -> assertEquals("E-mail для отправки чека", page.getCommunicationServiceEmailPlaceHolder()));
        System.out.println("Номер телефона, " + "Сумма, " + "E-mail для отправки чека" + " соответствуют");


    }

    @Test
    public void testPlaceHolderContainsInternetFields() {
        MtsPage page = new MtsPage(driver);
        page.selectService(MtsPage.internetOption);
        assertAll(() -> assertEquals("Номер абонента", page.getInternetNumberPlaceHolder()), () -> assertEquals("Сумма", page.getInternetAmountPlaceHolder()), () -> assertEquals("E-mail для отправки чека", page.getInternetEmailPlaceHolder()));

    }

    @Test
    public void testPlaceHolderContainsInstallmentFields() {
        MtsPage page = new MtsPage(driver);
        page.selectService(MtsPage.installmentOption);
        assertAll(() -> assertEquals("Номер счета на 44", page.getInstallmentAccountNumberPlaceHolder()), () -> assertEquals("Сумма", page.getInstallmentAmountPlaceHolder()), () -> assertEquals("E-mail для отправки чека", page.getInstallmentEmailPlaceHolder()));
        System.out.println("Номер счета на 44, " + "Сумма, " + "E-mail для отправки чека" + " соответствуют");

    }

    @Test
    public void testPlaceHolderContainsArrearsFields() {
        MtsPage page = new MtsPage(driver);
        page.selectService(MtsPage.arrearsOption);
        assertAll(() -> assertEquals("Номер счета на 2073", page.getArrearsAccountNumberPlaceHolder()), () -> assertEquals("Сумма", page.getArrearsAmountPlaceHolder()), () -> assertEquals("E-mail для отправки чека", page.getArrearsEmailPlaceHolder()));
    }

    @Test
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