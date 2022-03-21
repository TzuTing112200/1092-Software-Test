import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class student_309552017 {
    public static void main(String[] args)
    {
        // a
        WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        driver.get("https://www.nycu.edu.tw/");

        driver.findElement(By.linkText("消息")).click();
        List<WebElement> news = driver.findElements(By.cssSelector(".su-post"));
        news.get(0).findElement(By.cssSelector("a")).click();

        WebElement article = driver.findElement(By.id("post-1671"));
        List<WebElement> contents = article.findElements(By.cssSelector("p"));

        System.out.println(driver.getTitle());
        for(WebElement content : contents){
            System.out.println(content.getText());
        }
        System.out.println();

        // b
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("309552017");
        driver.findElement(By.name("btnK")).submit();

        WebElement search = driver.findElement(By.className("hlcw0c"));
        List<WebElement> results = search.findElements(By.cssSelector(".yuRUbf"));

        System.out.println(results.get(1).findElement(By.cssSelector("h3")).getText());

        driver.quit();
    }
}
