package week5.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day1.ProjectSpecificConfiguration;

public class DeleteTheIncident extends ProjectSpecificConfiguration1{
	@Test(dependsOnMethods = "week5.day1.assignments.AssignTheIncident.runTC003",alwaysRun =true)
	public void runTC004() {
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Siemens12$");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
		driver.findElement(By.xpath("(//ul[@id='concourse_application_tree']//div[text()='Incidents'])[2]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("INC0010066", Keys.ENTER);
		WebElement text = driver.findElement(By.xpath("//tbody[@class='list2_body']//td"));
		String incidentnumber = text.getText();
		if (incidentnumber.contains("No records to display")) {
			System.out.println("THe Incident is deleted");
		} else {
			System.out.println("THe Incident is not deleted");
		}
	}
}