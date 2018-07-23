import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirefoxSurfer extends Surfer implements Delayable{

  private long originalDelay;
  public long currentDelay;
  private long gifMultiplier;

  public FirefoxSurfer(){
    this(false, Long.MAX_VALUE, 1);
  }

  public FirefoxSurfer(boolean isFullScreen, long delay, long gifBuffer){
    super(new FirefoxDriver());
    this.gifMultiplier = gifBuffer;
    setDelay(originalDelay = delay);
    if(isFullScreen){
      webDriver.manage().window().fullscreen();
    }
  }

  @Override
  public void setDelay(long delay){
    this.currentDelay = delay;
  }

  @Override
  public void turn() {
    try {
      while (true){
        setDelay(originalDelay);
        webDriver.findElement(By.tagName("body")).sendKeys("j");
        if(webDriver.findElement(By.className("main-wrap")).findElements(By.className("gif-post")) != null){
          setDelay(originalDelay * gifMultiplier);
        }
        TimeUnit.SECONDS.sleep(originalDelay);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      webDriver.quit();
    }
  }

  @Override
  public void closePopups() {
    findElementByClass("button_button--lgX0P").click();
    clickActionBuilder(Arrays.asList(new String[]{"switch_native--3vL1-","details_save--1ja7w" })).build().perform();
  }

  public WebElement findElementByClass(String className){
    return webDriver.findElement(By.className(className));
  }

  public Actions clickActionBuilder(List<String> elements){
    Actions actions = new Actions(webDriver);
    for (String element: elements) {
      actions.moveToElement(findElementByClass(element)).click();
    }
    return actions;
  }
}
