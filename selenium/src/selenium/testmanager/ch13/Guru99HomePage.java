package selenium.testmanager.ch13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99HomePage {
	
	WebDriver driver;
	
//	By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	@FindBy(xpath="//table//tr[@class='heading3']")
	By homePageUserName;
	
	public Guru99HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// 홈페이지에서 사용자 이름 가져오기
	public String getHomePageDashboardUserName() {
		return driver.findElement(homePageUserName).getText();
	}
	
}
