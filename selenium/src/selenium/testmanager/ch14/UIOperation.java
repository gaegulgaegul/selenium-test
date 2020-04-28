package selenium.testmanager.ch14;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIOperation {
	
	WebDriver driver;
	
	public UIOperation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void perform(Properties p, String operation, String objectName, String objectType, String value) throws Exception {
		System.out.println("");
		
		switch(operation.toUpperCase()) {
		case "CLICK":
			driver.findElement(this.getObject(p, objectName, objectType)).click();
			break;
		case "SETTEXT":
			driver.findElement(this.getObject(p, objectName, objectType)).sendKeys(value);
			break;
		case "GOTOURL":
			driver.get(p.getProperty(value));
			break;
		case "GETTEXT":
			driver.findElement(this.getObject(p, objectName, objectType)).getText();
			break;
		default:
			break;
		}
	}
	
	public By getObject(Properties p, String objectName, String objectType) throws Exception {
		if("XPATH".equalsIgnoreCase(objectType)) {
			return By.xpath(p.getProperty(objectName));
		}
		else if("CLASSNAME".equalsIgnoreCase(objectType)) {
			return By.className(p.getProperty(objectName));
		}
		else if("NAME".equalsIgnoreCase(objectType)) {
			return By.name(p.getProperty(objectName));
		}
		else if("CSS".equalsIgnoreCase(objectType)) {
			return By.cssSelector(p.getProperty(objectName));
		}
		else if("LINK".equalsIgnoreCase(objectType)) {
			return By.linkText(p.getProperty(objectName));
		}
		else if("PARTIALLINK".equalsIgnoreCase(objectType)) {
			return By.partialLinkText(p.getProperty(objectName));
		}
		else {
			throw new Exception("Wrong object type");
		}
	}
	
}
