import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver driver;

    @BeforeMethod
    public void alertsTestPage(){
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/alert.xhtml");
        driver.manage().window().maximize();
    }

    @Test
    public void TestAlerts(){
        //Alert (Simple Dialog)
        driver.findElement(By.id("j_idt88:j_idt91")).click();
        //Alert (Confirm Dialog)
        //Alert (Prompt Dialog)
    }
}
