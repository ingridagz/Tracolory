package lt.techin.tracolory.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasePageTest {
WebDriver driver;

@BeforeEach
    void setup(){
    driver=new ChromeDriver();
    driver.get("https://practice.expandtesting.com/tracalorie/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
}
    public static void palaukti() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    @AfterEach
    void tearDown() {
//        driver.quit();
    }
}
