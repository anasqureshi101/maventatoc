package test.TatocMaven;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomatingTatoc {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\anasmoin\\Downloads\\chromedriver_win32\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.get("http://10.0.1.86/tatoc");
      WebElement linktext;
      linktext= driver.findElement(By.linkText("Basic Course"));
      linktext.click();
      
     WebElement greenbox;
     greenbox= driver.findElement(By.className("greenbox"));
     greenbox.click();
     
     driver.switchTo().frame(driver.findElement(By.id("main")));
     WebElement box1;
    // box1 = driver.findElement(By.xpath("//div[text()=Box 1]"));
       box1 = driver.findElement(By.id("answer"));
  
    String colorBox1= box1.getAttribute("class");
    System.out.println("Box 1"+ colorBox1);
    driver.switchTo().frame(driver.findElement(By.id("child")));
     WebElement box2 = null;
      //box2 = driver.findElement(By.xpath("//div[text()=Box 2]"));
     box2 = driver.findElement(By.id("answer"));
      String colorBox2= box2.getAttribute("class");  
     System.out.println("Box 2"+ colorBox2);
     WebElement reload;
   while(!colorBox1.equals(colorBox2)) {
	   
	   System.out.println("colorBox1" + colorBox1);
	   System.out.println("colorBox2" + colorBox2);
	 driver.switchTo().defaultContent();
     driver.switchTo().frame(driver.findElement(By.id("main")));
    
     reload= driver.findElement(By.linkText("Repaint Box 2"));
      reload.click();
   
         driver.switchTo().frame(driver.findElement(By.id("child")));
         box2 = driver.findElement(By.id("answer"));
          colorBox2= box2.getAttribute("class");  
          System.out.println("Box 2"+ colorBox2);
          
          
   }
   
   driver.switchTo().defaultContent();
   driver.switchTo().frame(driver.findElement(By.id("main")));
      WebElement proceed ;
   proceed = driver.findElement(By.linkText("Proceed"));
	proceed.click();   
	   
   
   
    Actions act = new Actions(driver);
    WebElement drag;
    WebElement drop;
   drag= driver.findElement(By.id("dragbox"));
   drop = driver.findElement(By.id("dropbox"));
   act.dragAndDrop(drag, drop).build().perform();
   
 
     WebElement next;
     next = driver.findElement(By.linkText("Proceed"));
     next.click();
     
         
     WebElement launch;
     launch = driver.findElement(By.linkText("Launch Popup Window"));
     launch.click();
     String parent = driver.getWindowHandle();
     Set s1 = driver.getWindowHandles();
     Iterator<String> I1 = s1.iterator();
     String parent_window = I1.next();
     String child_window = I1.next();
    
     driver.switchTo().window(child_window);
         //System.out.println("test123     " +driver.switchTo().window(child_window).getTitle());
         
         
    Thread.sleep(8000);     
    
   // boolean rest =driver.findElement(By.id("name")).isDisplayed();
  //  System.out.println( "456" +    rest);
    
    WebElement blank;
    blank = driver.findElement(By.id("name"));
    
 
    blank.sendKeys("anas");
    Thread.sleep(2000);
    WebElement submit;
    
    submit = driver.findElement(By.id("submit"));
    Thread.sleep(2000);
    submit.click();
    
    driver.switchTo().window(parent_window);
    
    WebElement pro;
    pro = driver.findElement(By.linkText("Proceed"));
    pro.click();
    
    driver.findElement(By.linkText("Generate Token")).click();
    String token_text = driver.findElement(By.id("token")).getText();
    String token = token_text.substring(token_text.indexOf(":")+2);
    Cookie cookie = new Cookie("Token",token);
    driver.manage().addCookie(cookie);
    driver.findElement(By.linkText("Proceed")).click();
    
	} 
    

}
