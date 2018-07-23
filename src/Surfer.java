import org.openqa.selenium.WebDriver;

public abstract class Surfer {
  public static final String PROTOCOL = "http://";
  protected String mainPage;
  protected WebDriver webDriver;

  public Surfer(WebDriver webDriver){
    this(webDriver, "9gag.com");
  }

  public Surfer(WebDriver webDriver, String mainPage){
    this.webDriver = webDriver;
    this.mainPage = httpProtocolAdder(mainPage);
  }

  public abstract void turn();

  public abstract void closePopups();

  protected String httpProtocolAdder(String url){
    if(!url.toLowerCase().startsWith(PROTOCOL)){
      url = PROTOCOL + url;
    }
    return url;
  }

  public void start() {
    webDriver.get(mainPage);
  }

  public void surf(){
    start();
    closePopups();
    turn();
  }
}
