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
