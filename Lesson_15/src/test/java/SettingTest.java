import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Duration defaultWaitDuration = Duration.ofSeconds(30);


    @BeforeEach
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, defaultWaitDuration);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}
