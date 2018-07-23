import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class App {

  public static final String BASE_URL = "http://9gag.com";

  public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver","/home/norbi/Documents/geckodriver");
    WebDriver webDriver = new FirefoxDriver();

    webDriver.manage().window().fullscreen();

    webDriver.get(BASE_URL);

    webDriver.findElement(By.className("closebutton_closeButton--3abym")).click();

    try {
      while (true){
        long delay = 5;
        webDriver.findElement(By.tagName("body")).sendKeys("j");
        if(webDriver.findElement(By.className("main-wrap")).findElements(By.className("gif-post")) != null){
          delay = 15;
        }
        TimeUnit.SECONDS.sleep(delay);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      webDriver.quit();
    }
  }
}
