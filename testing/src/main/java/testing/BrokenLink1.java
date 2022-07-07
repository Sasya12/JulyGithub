
package testing;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BrokenLink1 {
    public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		List<WebElement> links =driver.findElements(By.tagName("a"));
		int size=links.size();
		System.out.println(size);
		for(int i=0;i<size;i++)
		{
			WebElement elements=links.get(i);
		    String url=elements.getAttribute("href");
		    
		   URL link=new URL(url);
		   HttpURLConnection ttpcon= (HttpURLConnection) link.openConnection();
		   ttpcon.connect();
		   int rescode=ttpcon.getResponseCode();
		   if(rescode>400)
		   {
			   System.out.println(url +"----->its a broken link");
		   }
		   else
		   {
			   System.out.println(url +"------>its a valid link");
		   }
		}
		
	}

}
