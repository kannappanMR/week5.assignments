package week5.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateExistingIncident extends ProjectSpecificConfiguration1 {
	@Test
	public void runTC002() {

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Siemens12$");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
		driver.findElement(By.xpath("(//ul[@id='concourse_application_tree']//div[text()='Incidents'])[2]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("INC0010070", Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement state = driver.findElement(By.xpath("(//select[@role='listbox'])[4]"));
		Select dd = new Select(state);
		dd.selectByVisibleText("In Progress");
		WebElement urgency = driver.findElement(By.xpath("(//select[@role='listbox'])[7]"));
		Select dd1 = new Select(urgency);
		dd1.selectByIndex(0);
		driver.findElement(By.xpath("(//button[contains(@class,'form_action_button')])[4]")).click();
		WebElement stateText = driver.findElement(By.xpath("(//td[@class='vt'])[6]"));
		String state1 = stateText.getText();
		WebElement priority = driver.findElement(By.xpath("(//td[@class='vt'])[5]"));
		String priority1 = priority.getText();
		if (state1.contains("In Progress")) {
			System.out.println("Then the state is updated");
		} else {
			System.out.println("Then the state is not updated");
		}
		if (priority1.contains("3 - Moderate")) {
			System.out.println("Then the urgency is updated");
		} else {
			System.out.println("Then the urgency is not updated");
		}
	}
}
