

import lesson_15.MtsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PaySectionTest {

    public static WebDriver driver;
    public static MtsPage mtsPage;
    public static String PAGE_URL = "https://mts.by";

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

    @ParameterizedTest
    @DisplayName("Тест 1: Проверка плейсхолдеров формы оплаты на главной странице")
    @CsvSource({
            "connection-phone, Номер телефона",
            "connection-sum, Сумма",
            "connection-email, E-mail для отправки чека",
            "internet-phone, Номер абонента",
            "internet-sum, Сумма",
            "internet-email, E-mail для отправки чека",
            "score-instalment, Номер счета на 44",
            "instalment-sum, Сумма",
            "instalment-email, E-mail для отправки чека",
            "score-arrears, Номер счета на 2073",
            "arrears-sum, Сумма",
            "arrears-email, E-mail для отправки чека"
    })
    public void checkPlaceholders(String id, String expectedPlaceholder) {
        try {
            String actualPlaceholder = "";
            switch (id) {
                case ("connection-phone"):
                    actualPlaceholder = mtsPage.getConnectionPhonePlaceholder();
                    break;
                case ("connection-sum"):
                    actualPlaceholder = mtsPage.getConnectionSumPlaceholder();
                    break;
                case ("connection-email"):
                    actualPlaceholder = mtsPage.getConnectionEmailPlaceholder();
                    break;
                case ("internet-phone"):
                    actualPlaceholder = mtsPage.getInternetPhonePlaceholder();
                    break;
                case ("internet-sum"):
                    actualPlaceholder = mtsPage.getInternetSumPlaceholder();
                    break;
                case ("internet-email"):
                    actualPlaceholder = mtsPage.getInternetEmailPlaceholder();
                    break;
                case ("score-instalment"):
                    actualPlaceholder = mtsPage.getInstalmentScorePlaceholder();
                    break;
                case ("instalment-sum"):
                    actualPlaceholder = mtsPage.getInstalmentSumPlaceholder();
                    break;
                case ("instalment-email"):
                    actualPlaceholder = mtsPage.getInstalmentEmailPlaceholder();
                    break;
                case ("score-arrears"):
                    actualPlaceholder = mtsPage.getArrearsScorePlaceholder();
                    break;
                case ("arrears-sum"):
                    actualPlaceholder = mtsPage.getArrearsSumPlaceholder();
                    break;
                case ("arrears-email"):
                    actualPlaceholder = mtsPage.getArrearsEmailPlaceholder();
                    break;
            }
            assertEquals(actualPlaceholder, expectedPlaceholder, id + " плейсхолдер не соответствует");
            System.out.println(id + " плейсхолдер соответствует");
        } catch (NoSuchElementException e) {
            assertTrue(false, id + " плейсхолдер не найден");
        }
    }
}
