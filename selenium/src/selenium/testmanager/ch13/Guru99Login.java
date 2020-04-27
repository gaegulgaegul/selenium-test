package selenium.testmanager.ch13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99Login {
	
	WebDriver driver;
	
	@FindBy(name="uid")
	By user99GuruName = By.name("uid");
	
	@FindBy(name="password")
	By password99Guru = By.name("password");
	
	@FindBy(name="barone")
	By titleText = By.className("barone");
	
	@FindBy(name="btnLogin")
	By login = By.name("btnLogin");
	
	public Guru99Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// 텍스트 상사에 사용자 이름을 입력한다.
	public void setUserName(String strUserName) {
		driver.findElement(user99GuruName).sendKeys(strUserName);
	}
	
	// 암호 텍스트에 비밀번호를 입력한다.
	public void setPassword(String strPassword) {
		driver.findElement(password99Guru).sendKeys(strPassword);
	}
	
	// 로그인 버튼을 클릭한다.
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	// 로그인 페이지의 제목 가져오기
	public String getLoginTitle() {
		return driver.findElement(titleText).getText();
	}
	
	public void loginToGuru99(String strUserName, String strPassword) {
		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickLogin();
	}
	
}
