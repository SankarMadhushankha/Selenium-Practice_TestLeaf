import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DroDownExample {
    WebDriver driver;
    @BeforeMethod
    public void DropDownTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void DropDownTest() throws InterruptedException {
        driver.get("https://www.leafground.com/select.xhtml;jsessionid=node0gc3uomsz45c1vr4dvxz8pdfm8286114.node0");
        //1 Ways of select values in Basic dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Cypress");
        Thread.sleep(3000);


        //2 Get the number of dropdown options
        List<WebElement> listofOptions =  select.getOptions();
        int size=listofOptions.size();
        System.out.println("Number of elements in drop down :"+ size);

        for (WebElement elements:listofOptions){
            System.out.println(elements.getText());
        }

        //3 Using sendkeys select dropdown value
        dropDown.sendKeys("Playwright");
        Thread.sleep(3000);


        //4 Selecting a value in a bootstra dropdown

        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> dropdown2Values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : dropdown2Values){
            String dropdownValue = element.getText();

            if (dropdownValue.equals("Germany")){
                element.click();
                break;
            }
        }
    }

    //Google search-pick a value from suggestions

    @Test
    public void GoogleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Vijay");
        Thread.sleep(2000);
        List<WebElement> googlevijaysearch = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='wM6W7d']"));
        System.out.println(googlevijaysearch.size());

        for (WebElement element : googlevijaysearch){
            System.out.println(element.getText());
        }
    }

}
