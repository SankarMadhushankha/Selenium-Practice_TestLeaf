import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {
    public static void main(String[] args){
        //open google
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();

    }
}
