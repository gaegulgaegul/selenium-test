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
  // 웹 브라우저를 띄우고 싶지 않은 경우 추가
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

### 2.7. Form 액세스
- WebElement
  - findElement() : 단일 웹 요소를 찾아 WebElement로 반환
  - findElements() : 로케이터 기준과 일치하는 List&lt;WebElement&gt;로 반환
- 값 입력 및 삭제
  - sendKeys() : 텍스트 입력 란을 찾아 값을 입력한다.
  - clear() : 텍스트 입력 값을 삭제한다.

### 2.8. SelectBox 제어
- Select 클래스
  - &lt;SELECT&gt; 요소를 제어하는데 사용되는 클래스

메소드|설명
---|---|
selectByVisibleText()<br/>deselectByVisibleText()|매개 변수와 일치하는 텍스트를 가진 옵션을 선택/취소한다.
selectByValue()<br/>deselectByValue()|'value'속성이 지정된 매개 변수와 일치하는 옵션을 선택/취소한다.
selectByIndex()<br/>deselectByIndex()|매개 변수로 주어진 인덱스의 옵션을 선택/취소한다.
isMultiple()|selectBox가 한번에 여러 항목을 선택할 수 있으면 true 아니면 flase
deselectAll()|선택한 모든 항목을 지운다.(selectBox가 다중 선택을 지원한 경우만 가능하다.)

### 2.9. 링크 및 테이블 접근 제어
- By.linkText(): 매개 변수와 링크 텍스트가 정확하게 일치되는 링크를 찾는다.
- By.partialLinkText(): 매개 변수와 링크 텍스트가 부분 일치되는 링크를 찾는다.
- 링크 매칭 시에 대소문자를 구별하여 매칭시킨다.
- By.linkText() / By.partialLinkText() : 여러 링크 중 첫번째 일치되는 항목만 가져온다.
- xpath / css 기반 위치 지정자 : 여러 링크가 있는 경우 일치하는 링크를 가져온다.
- 이미지 링크에 접근하려면 By.cssSelector() 또는 By.xpath()를 사용한다.
- 테이블에 접근하려면 By.xpath()를 사용한다.

### 2.10. 마우스 및 키보드 이벤트 처리
메소드|설명
--|--|
clickAndHold()|현재 마우스 위치에서 클릭하지 않는다.
contextClick()|현재 마우스 위치에서 컨텍스트 클릭을 수행한다.
doubleClick()|현재 마우스 위치에서 더블 클릭한다.
dragAndDrop(source, target)|지정된 'target'에 'source'를 드래그 앤 드랍한다.
dragAndDrop(source, x-offset, y-offser)|지정된 오프셋 만큼 이동하여 'source'를 드래그 앤 드랍한다.
keyDown(modifier_key)|키보드의 키 누름을 수행한다.
keyUp(modifier_key)|키보드의 키 릴리즈를 수행한다.
moveByOffset(x-offset,y-offset)|지정된 오프셋만큼 마우스를 현재 위치(또는 0,0)에서 이동한다.
moveToElement(toElement)|요소의 가운데로 마우스를 이동한다.
release()|현재 마우스 위치에서 마우스 왼쪽 버튼을 놓는다.
sendKeys(onElement, charsequence)|태그에 값을 입력한다.

- 특수 키보드 및 마우스 이벤트 처리는 AdvancedUserInteractions API를 사용하여 수행된다.
- 자주 사용되는 키보드 및 마우스 이벤트 :  doubleClick(), keyUp(), dragAndDropBy(), contextClick(), sendKeys()

### 2.11. 파일 업로드 및 다운로드
- WebDriver에서 파일 업로드는 단순히 파일 태그에서 sendKeys()를 사용하여 파일의 경로를 입력한다.
- WebDriver는 자체적인 파일 다운로드를 자동화 할 수 없다.
- WebDriver를 사용하여 파일 다운로드 하는 가장 쉬운 방법은 wget을 사용하는 것이다.

### 2.12. POM 및 PageFactory
- POM(Page Object Model)
  - 웹 UI 요소에 대한 객체 저장소를 만드는 디자인 패턴
  - 객체 저장소가 테스트 케이스와 독립적이므로 다른 툴을 사용하여 동일한 목적을 위해 동일한 객체저장소를 사용할 수 있다.
- PageFactory
  - Selenium WebDriver를 위해 내장된 POM 개념을 최적화한다.
  - @FindBy 어노테이션을 사용하여 tagName, partialLinkText, name, linkText, id, css, className, xpath를 속성으로 사용한다.
  - initElements 메서드를 이용하여 웹 요소를 초기화한다.

### 2.13. Ajax
- Ajax를 사용하면 웹 페이지가 전체 페에지를 다시 로드 하지 않고 서버에서 소향의 데이터를 검색할 수 있다.
- Ajax를 테스트 하려면 대기 메서드가 적용되어야 한다.
  - Thread.sleep
  - Implicit Wait
  - Explicit Wait
- Ajax는 다른 인코딩이나 직렬화 기술을 사용하여 POST 데이터를 전달하기 때문에 자동화 된 테스트 요청을 작성하는 테스트 도구에서는 어려울 수 있다.