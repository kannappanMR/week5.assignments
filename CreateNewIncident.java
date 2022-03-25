package week5.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewIncident extends ProjectSpecificConfiguration1{
	@Test
	public void runTC001() throws InterruptedException {

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Siemens12$");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@name='lookup.incident.caller_id']")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> allWindowHandlesList = new ArrayList<String>(windowHandlesSet);
		String newWindow = allWindowHandlesList.get(1);
		driver.switchTo().window(newWindow);
		driver.findElement(By.xpath("(//a[@class ='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(allWindowHandlesList.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.id("lookup.incident.short_description")).click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> allWindowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		String newWindow1 = allWindowHandlesList1.get(1);
		driver.switchTo().window(newWindow1);
		driver.findElement(By.linkText("Issue with a web page")).click();
		driver.switchTo().window(allWindowHandlesList.get(0));
		String IncidentNumber = "INC0010070";
		driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys(IncidentNumber, Keys.ENTER);
		WebElement text = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		String number = text.getText();
		if (number.equals(IncidentNumber)) {
			System.out.println("The incident is created");
		} else {
			System.out.println("The incident is not created");
		}
	}
}