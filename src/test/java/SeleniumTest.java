import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    private static WebDriver webDriver;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "--headless");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://chercher.tech/practice/dynamic-table");
    }

    @AfterEach
    void tearDown(){
        webDriver.quit();
    }

    @Test
    void deveSelecionarBlueBerry() {

        WebElement blueBerry = webDriver.findElement(By.xpath("//*[@id=\"blue\"]"));
        blueBerry.click();
        WebElement output = webDriver.findElement(By.id("output"));

        assertEquals(blueBerry.getText(), output.getText());

    }

    @Test
    void deveSelecionarGoogle(){
        WebElement google = webDriver.findElement(By.id("table"));


    }

}
