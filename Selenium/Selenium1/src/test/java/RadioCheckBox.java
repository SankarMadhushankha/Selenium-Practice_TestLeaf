import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioCheckBox {

    WebDriver driver;

    @BeforeMethod
    public void radio_checkbox_BeforTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Radio_Test() throws InterruptedException {
        //Find the default select radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeradioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefox_radioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariradioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeradioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeradioOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("Default selected radio button is : " +chromeText);
            Thread.sleep(3000);
        } else if (firefox_radioOption) {
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Default selected radio button is : " +firefoxText);
            Thread.sleep(3000);
        } else if (safariradioOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Default selected radio button is : " +safariText);
            Thread.sleep(3000);
        } else if (edgeradioOption) {
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Default selected radio button is : " +edgeText);
            Thread.sleep(3000);
        }

        //Select the age group (only if not selected)
        WebElement ageGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = ageGroup.isSelected();
        if (!isChecked){
            //ageGroup.click();
            driver.findElement(By.xpath(" //label[@for='j_idt87:age:0']")).click();
            Thread.sleep(3000);
        }
    }

    @Test
    public void Checkbox_Test() throws InterruptedException {
        //Select wanted check box and verifying those selected status
        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> checkboxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element: checkboxList){
            if (!(element.getText().equals("Others"))){
                element.click();
                Thread.sleep(3000);
            }
        }
        for (int i = 1; i<=checkboxList.size(); i++){
            boolean checkboxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+i+"]")).isSelected();
            System.out.println("Check Box" +i+ "selected status is : " + checkboxStatus);
        }
    }
}
