//objective of the program is to take  screenshot automatically from amazon 
package testing;
import java.io.File;
import javax.imageio.ImageIO;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;
import ru.yandex.qatools.ashot.AShot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ashot1program {
	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.co.uk");
		Thread.sleep(5000);
		File f1=driver.getScreenshotAs(OutputType.FILE);//get screenshot of visible area
		File dest1=new File("haripriya defect on amazon screenshot.png");
		FileHandler.copy(f1, dest1);
		Thread.sleep(5000);
		//get screenshot of full page(AShot)
		AShot as=new AShot();
		ShootingStrategy shs = ShootingStrategies.viewportPasting(1000);
		Screenshot ss=as.shootingStrategy(shs).takeScreenshot(driver);
		File dest=new File("fullpagesScreenshotjune1"
				 +""
				 +".png");
		ImageIO.write(ss.getImage(),"PNG",dest);
		Thread.sleep(5000);
		// TODO Auto-generated method stub
      }
}
