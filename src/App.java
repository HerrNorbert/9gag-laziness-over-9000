public class App {

  public static final String BASE_URL = "http://9gag.com";

  public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver","/home/norbi/Documents/geckodriver");
    FirefoxSurfer surfer = new FirefoxSurfer(false, 5, 3);
    surfer.surf();
  }
}
