# selenium-test
셀레니움을 이용한 웹 테스트 자동화

## 1. 기술 스택
- JDK 1.8
- STS 4
- client-combined-3.141.59
- chromedriver 80.0.3987.16

## 2. 실습
### 2.1. 웹 크롤링
``` Java
  // Driver SetUp
  driver = new ChromeDriver();

  driver.get(base_url);
  System.out.println(driver.getPageSource());
```

### 2.2. 웹 로그인
``` Java
  // Driver SetUp
  ChromeOptions options = new ChromeOptions();
  options.setCapability("ignoreProtextedModeSettings", true);
  // 웹 브라우저를 띄우고 싶지 않으 경우 추가
  options.addArguments("headless");
  driver = new ChromeDriver(options);

  driver.get(base_url);

  // id 필드 탐색
  webElement = driver.findElement(By.id("id"));
  String daum_id = "your_id";
  webElement.sendKeys(daum_id);

  // pw 필드 탐색
  webElement = driver.findElement(By.id("inputPwd"));
  String daum_pw = "your_pw";
  webElement.sendKeys(daum_pw);

  // 로그인 버튼 클릭
  webElement = driver.findElement(By.id("loginBtn"));
  webElement.submit();
```

### 2.3. 요소 찾기
코드|설명|예제
---|---|---|
By.className|"class" 속성 값을 통해 요소를 찾는다.|findElement(By.className("someClassName"))|
By.classSelector|드라이버의 기본 CSS Selector 엔진을 기반으로 속성을 찾는다.|findElement(By.cssSelector("input#email))|
By.id|요소를 "id" 속성 값으로 찾는다.|findElement(By.id("somdId))|
By.linkText|텍스트 링크를 통해 속성 값을 요소를 찾는다.|findElement(By.linkText("REGISTRATION"))|
By.name|"name" 속성 값에 따라 요소를 찾는다.|findElement(By.name("someName"))|
By.partialLinkText|지정된 링크 텍스트를 포함하는 요소를 찾는다.|findElement(By.partialLinkText("REG))|
By.tagName|태그 이름으로 요소를 찾는다.|findElement(By.tagName("div"))|
By.xpath|XPath를 통해 요소를 찾는다.|findElement(/) / table / tbody / tr / td(2) / table / tr(4) / td|
- By.cssSelector()는 "contains(포함)" 기능을 지원하지 않는다.
- WebElement 클래스를 사용하여 요소를 인스턴스화 할 수 있다.

### 2.4. 명령
- click()
  - 이 메소드는 적용 가능한 경우 새 페이지가 로드 될 때까지 자동으로 대기한다.
  - 클릭 할 요소가 표시 되어야 한다.(높이와 너비가 0이 아니여야 한다.)

- Get Commands
  - get()
    - 자동으로 새 브라우저 창을 열고 괄호 안에 지정한 페이지를 가져온다.
    - 브라우저 기록 및 쿠키가 유지되지 않으므로 앞뒤 방향 버튼을 사용할 수 없다.
  - getTitle()
    - 현재 페이지의 제목을 가져온다.
    - 선후행 공백이 제거된다.
  - getPageSource()
    - 페이지의 소스코드를 반환한다.
  - getCurentUrl()
    - 브라우저가 보고있는 현재 URL을 나타내는 문자열을 가져온다.
  - getText()
    - 지정한 요소의 내부 텍스트를 가져온다.

- Navigate Commands
  - navigate()
    - 브라우저 기록 및 쿠키를 유지하여 앞뒤 방향 버튼을 사용하여 페이지 간 이동이 가능하다.
  - navigate().to()
    - 새 브라우저 창을 열고 지정한 페이지를 가져온다.
  - navigate().refresh()
    - 현재 페이지 새로고침
  - navigate().back()
    - 이전 페이지로 이동한다.
  - navigate().forward()
    - 지정한 페이지로 이동한다.

- 종료
  - close()
    - WebDriver가 제어하고 있는 현재 브라우저 창만 닫는다.
  - quit()
    - 모든 창을 닫는다.

### 2.5. 프레임 간 전환
```Java
public class PG4 {
	
	public static void main(String[] args) {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/selenium/deprecated.html");
		
		// 프레임의 name속성을 이용하여 전환
		driver.switchTo().frame("classFrame");
		
		// Deprecated 링크 텍스트 클릭
		driver.findElement(By.linkText("Deprecated")).click();
		
		driver.close();
	}

}
```

### 2.6. 팝업 창 전환
```Java
public class PG5 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		String alertMessage = "";
		
		driver.get("http://jsbin.com/usidix/1");
		// input 태그 중 value가 'Go!'인 태그 클릭
		driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
		
		// 열려있는 alert으로 전환 후 텍스트 가져오기
		alertMessage = driver.switchTo().alert().getText();
		
		// alert 닫기
		driver.switchTo().alert().accept();
		
		System.out.println(alertMessage);
		driver.close();
	}

}
```