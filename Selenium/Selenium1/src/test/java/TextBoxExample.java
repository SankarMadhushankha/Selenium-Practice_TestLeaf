import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() throws InterruptedException {
        //opentestpage
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void TextBoxTests() throws InterruptedException {
        //01 Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Madhushankha");
        Thread.sleep(2000);

        //02 Append Country to this City.
        WebElement AppendText = driver.findElement(By.id("j_idt88:j_idt91"));
        AppendText.clear();
        Thread.sleep(2000);
        AppendText.sendKeys("India");
        Thread.sleep(2000);

        //03 Verify if text box is disabled
        boolean TextBoxEnable = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Text Box Enabled : "+TextBoxEnable);

        //04 Clear the typed text.
        WebElement ClearText = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        ClearText.clear();
        Thread.sleep(3000);

        //05 Retrieve the typed text.
        WebElement Retrive = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = Retrive.getAttribute("value");
        Thread.sleep(2000);
        System.out.println(value);
        Thread.sleep(2000);

        //06Type email and Tab. Confirm control moved to next element.

        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("iit20064@std.uwu.ac.lk"+ Keys.TAB+" I am an undergraduate student currently pursuing a BSc (Hons) in Industrial Information Technology at Uva Wellassa University. With a strong passion for software quality assurance, I am committed to ensuring that software adheres to the highest standards of performance, reliability, and user satisfaction. My goal is to contribute to the creation of seamless user experiences by identifying and resolving issues, while supporting the delivery of high-quality software solutions.");
        Thread.sleep(3000);
    }
}
