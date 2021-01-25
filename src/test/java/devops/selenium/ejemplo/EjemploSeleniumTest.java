package devops.selenium.ejemplo;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class EjemploSeleniumTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	@Test
	public void testEjemploSelenium() {
		
		WebElement buscador = driver.findElement(By.name("q"));
		buscador.clear();
		buscador.sendKeys("TDD");
		buscador.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("TDD - Buscar con Google", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	

}
