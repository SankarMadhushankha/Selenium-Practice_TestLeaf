import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){
        //opentestpage
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }
    @Test
    public void LinkTest() throws InterruptedException {
        //take me to dashboard
        WebElement homelink = driver.findElement(By.linkText("Go to Dashboard"));
        homelink.click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);

        //Find my destination
        WebElement destination = driver.findElement(By.partialLinkText("Find the URL"));
        String path = destination.getAttribute("href");
        System.out.println("This link is going to " +path);

        //Broken link
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();


        String title = driver.getTitle();

        if (title.contains("404")){
            System.out.println("The link is Broken !.");
        }else {
            System.out.println("Not Broken");
        }
        driver.navigate().back();


        //Duplicate link
        WebElement homelink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homelink1.click();
        Thread.sleep(2000);
        driver.navigate().back();

        //Count page links
        List<WebElement> countfullpagelink =  driver.findElements(By.tagName("a"));
        int pagelinkcount = countfullpagelink.size();
        System.out.println("Counts of full page links : " +pagelinkcount);

        //Count layout link
        WebElement layoutlinks = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countofthelayoutlinks = layoutlinks.findElements(By.tagName("a"));
        System.out.println("Count of layout links : "+countofthelayoutlinks.size());
    }
}
