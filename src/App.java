import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {

  public static final String BASE_URL = "http://9gag.com";

  public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver","/home/norbi/Documents/geckodriver");
    WebDriver webDriver = new FirefoxDriver();

    webDriver.get(BASE_URL);
    webDriver.manage().window().fullscreen();

  }
}
