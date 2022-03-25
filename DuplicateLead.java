package week5.day1.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends ProjectSpecificMethod {
	@Test(priority = -1)
	public void tc02() {
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Siemens");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vinoth");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("KS");
		WebElement elementDropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd = new Select(elementDropDown);
		dd.selectByValue("LEAD_COLDCALL");
		List<WebElement> options = dd.getOptions();
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Private");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("programmingTesting");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("dealswithplcandscadaforbms");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("murugappankannappan@gmail.com");
		WebElement elementDropDown1 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd1 = new Select(elementDropDown1);
		dd1.selectByValue("NY");
		WebElement firstSelectedOption = dd1.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
		List<WebElement> options1 = dd1.getOptions();
		for (int j = 0; j < options1.size(); j++) {
			System.out.println(options1.get(j).getText());
		}
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("The Title is:" + driver.getTitle());
		driver.findElement(By.className("subMenuButton")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Amazon");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kanna");
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("The Title is:" + driver.getTitle());

	}

}
