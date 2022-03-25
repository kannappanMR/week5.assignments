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

public class AssignTheIncident extends ProjectSpecificConfiguration1{

	@Test
	public void runTC003() {
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Siemens12$");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
		driver.findElement(By.xpath("(//ul[@id='concourse_application_tree']//div[text()='Incidents'])[2]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("INC0010070", Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> allWindowHandlesList = new ArrayList<String>(windowHandlesSet);
		String newWindow = allWindowHandlesList.get(1);
		driver.switchTo().window(newWindow);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("software", Keys.ENTER);
		driver.findElement(By.linkText("Software")).click();
		driver.switchTo().window(allWindowHandlesList.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//button[contains(@class,'form_action_button')])[4]")).click();
		WebElement text = driver.findElement(By.xpath("(//a[@class='linked'])[2]"));
		String AssignmentGroup = text.getText();
		if (AssignmentGroup.contains("Software")) {
			System.out.println("The incident is assigned");
		} else {
			System.out.println("The incident is not assigned");
		}
	}
}
