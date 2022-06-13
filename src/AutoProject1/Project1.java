package AutoProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Project1 {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","/Users/sabinahuseynly/Documents/BrowserDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

       // 1. Navigate to http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

       // 2. Verify the the title is "Welcome to Duotify!"
        String actualTitle = driver.getTitle();
        String expectedTitle ="Welcome to Duotify!";
        Assert.assertEquals(actualTitle,expectedTitle);


       // 3. Click on Signup here link

       driver.findElement(By.id("hideLogin")).click();


      //4. Fill out the form with the required info
        driver.findElement(By.name("username")).sendKeys("Sabina1105");
        driver.findElement(By.name("firstName")).sendKeys("Sabina");
        driver.findElement(By.name("lastName")).sendKeys("Huseynly");
        driver.findElement(By.name("email")).sendKeys("Sabina1105@hotmail.com");
        driver.findElement(By.name("email2")).sendKeys("Sabina1105@hotmail.com");
        driver.findElement(By.name("password")).sendKeys("Sabina1105");
        driver.findElement(By.name("password2")).sendKeys("Sabina1105");
       // Thread.sleep(1000);
       // 5. Click on Sign up button
        driver.findElement(By.name("registerButton")).click();
        Thread.sleep(1000);

//       Sign in by using existing username and password:
        driver.findElement(By.id("hideRegister")).click();
        driver.findElement(By.id("loginUsername")).sendKeys("Sabina1105");
        driver.findElement(By.id("loginPassword")).sendKeys("Sabina1105");
        driver.findElement(By.name("loginButton")).click();
        Thread.sleep(1000);

        //6. Once logged in to the application, verify that the URL is:
       // http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl ="http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        Assert.assertEquals(currentUrl,expectedUrl);
       // Thread.sleep(1000);

//        7. In the left navigation bar, verify that your first and last name matches the first and last name that you used when signing up.
//        (Use getText() method to extract the text from the WebElement)
        String pageSource = driver.getPageSource();
        String expectedFirstAndLastName ="Sabina Huseynly";
        Assert.assertTrue(pageSource.contains(expectedFirstAndLastName));
        Thread.sleep(1000);

//        8. Click on the username on the left navigation bar and verify the username on the main window above the
//        User Details button is correct and then click logout.
        driver.findElement(By.id("nameFirstAndLast")).click();
        String pageSource2 = driver.getPageSource();
        String expectedFirstAndLastName2 ="Sabina Huseynly";
        Assert.assertTrue(pageSource2.contains(expectedFirstAndLastName2));
        Thread.sleep(1000);
        driver.findElement(By.id("rafael")).click();//logout
        Thread.sleep(1000);

//        10. Verify that you are logged out by verifying the URL is:
//        http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php
        String currentUrl2 = driver.getCurrentUrl();
        String expectedUrl2 ="http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php";
        Assert.assertEquals(currentUrl2,expectedUrl2);
        Thread.sleep(1000);

//        11. Login using the same username and password when you signed up.

        driver.findElement(By.name("loginUsername")).sendKeys("Sabina1105");
        driver.findElement(By.name("loginPassword")).sendKeys("Sabina1105");
        driver.findElement(By.name("loginButton")).click();
        Thread.sleep(1000);

//        12. Verify successful login by verifying that the home page contains the text "You Might Also Like".

        String pageSource3 = driver.getPageSource();
        String expectedFirstAndLastName3 ="You Might Also Like";
        Assert.assertTrue(pageSource3.contains(expectedFirstAndLastName3));
        Thread.sleep(1000);

//        13. Log out once again and close the browser.
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("rafael")).click();
        Thread.sleep(1000);
        driver.close();

    }
}
