package Day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {

    // Bir Class olusturalim YanlisEmailTesti
    //http://automationpractice.com/index.php sayfasina gidelim
    //Sign in butonuna basalim
    //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
    //   “Invalid email address” uyarisi ciktigini test edelim
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationpractice.com/index.php");


    }

    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test01(){
        driver.findElement(By.xpath("//a[@class='login']")).click();

        WebElement mailBox = driver.findElement(By.xpath("//input[@id='email_create']"));
        mailBox.sendKeys("aliveli4950" + Keys.ENTER);

        WebElement uyarıYazisiElementi = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));

        Assert.assertTrue(uyarıYazisiElementi.isDisplayed());


    }
}
