import org.example.MtsPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class PaySectionTest {
    public static MtsPage mtsPage;
    public static WebDriver driver;
    public static final String PAGE_URL = "http://mts.by";

    @BeforeAll
    static void before() {
        driver = new ChromeDriver();
        mtsPage = new MtsPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        mtsPage.clickCookieCancelBtn();
    }

    @AfterAll
    static void after() {
        driver.quit();
    }

    @Test
    @DisplayName("Заголовок формы")
    public void title() {
        String name = "Заголовок";
        try {
            String actualValue = mtsPage.getPaySectionTitle();
            assertEquals("Онлайн пополнение без комиссии", actualValue, name + " не совпадает");
            System.out.println(name + " совпадает: " + actualValue);
        } catch (NoSuchElementException e) {
            assertTrue(false, name + " не найден");
        }
    }

    @ParameterizedTest
    @DisplayName("Логотипы платежных систем")
    @ValueSource(strings = {"visa.svg", "visa-verified.svg", "mastercard.svg", "mastercard-secure.svg", "belkart.svg"})
    void payPics(String src) {
        try {
            assertTrue(mtsPage.isDisplayedImg(src), "Логотип " + src + " не отображается");
            System.out.println("Логотип " + src + " отображается");
        } catch (NoSuchElementException e) {
            assertTrue(false, "Логотип " + src + " не найден");
        }
    }

    @Test
    @DisplayName("Ссылка 'Подробнее о сервисе'")
    void detailLink() {
        String urlLink = null;
        try {
            urlLink = mtsPage.getLinkUrl();
            int linkResponseCode = mtsPage.getRespCode(urlLink);
            assertTrue(linkResponseCode < 400, "Ссылка " + urlLink + " битая (код: " + linkResponseCode + ")");
            System.out.println("Ссылка " + urlLink + " рабочая (код: " + linkResponseCode + ")");
        } catch (NoSuchElementException e) {
            assertTrue(false, "Нет ссылки");
        } catch (MalformedURLException e) {
            assertTrue(false, "Не корректный url: " + urlLink);
        } catch (IOException e) {
            assertTrue(false, "Проблема с соединением");
        }
    }

    @Test
    @DisplayName("Работа кнопки 'Продолжить'")
    void payForm() {
        String name = "Окно оплаты после нажатия кнопки 'Продолжить'";
        try {
            mtsPage.setPhoneField("297777777");
            mtsPage.setSumField("100");
            mtsPage.clickPayBtn();
            String actualValue = mtsPage.getFrameLink();
            assertEquals("https://checkout.bepaid.by/widget_v2/index.html", actualValue, name + " не открылось");
            System.out.println(name + " открылось");
        } catch (NoSuchElementException e) {
            assertTrue(false, "Элемент не найден");
        }
    }
}
