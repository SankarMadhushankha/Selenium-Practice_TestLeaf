import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {
    WebDriver driver;

    @BeforeMethod
    public void OpenButtonTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml;jsessionid=node0abbahscmt1mkzbh1xpr6904r8235164.node0");
    }
    @Test
    public void ButtonTest(){
        // 01 Click and Confirm title.
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle ="Dashboard";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Actual title is same as expected.");
        }else {
            System.out.println("Actual title is not same as expected.");
        }
        //Assert.assertEquals(actualTitle,expectedTitle, "Title miss matched.");

        // 02Find the position of the Submit button
        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position is : "+ x + " Y position is : "+y);

        //Find the Save button color
        WebElement buttonColour = driver.findElement(By.id("j_idt88:j_idt96"));
        String colour = buttonColour.getCssValue("background-color");
        System.out.println("The Button colour is : "+colour);

        //Find the height and width of this button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("The Height is : " + height + " The Width is : " + width);
    }
}
