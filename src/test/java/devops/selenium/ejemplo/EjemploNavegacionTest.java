package devops.selenium.ejemplo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemploNavegacionTest {
	
	private WebDriver driver; 
	By btnSignIn = By.linkText("Sign in");
	By pagSignIn = By.xpath("//img[@src='http://automationpractice.com/img/logo.jpg']");
	By boxEmail = By.id("email_create");
	By btnCreate = By.name("SubmitCreate");
	By boxEmailPreCargado = By.id("email");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
		driver = new ChromeDriver();
		// construimos nuestro web driver con el driver de Chrome
		driver.manage().window().maximize();
		//maximizamos el Chrome
		driver.get("http://automationpractice.com/index.php");
		//cargamos el sitio
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void registrarUsuarioTest() throws InterruptedException {
		driver.findElement(btnSignIn).click();
		//damos click al boton Sign In
		Thread.sleep(2000);
		//esperamos 2 segundos
		if(driver.findElement(pagSignIn).isDisplayed()) {
			//si la página de Sign In está desplegada
			driver.findElement(boxEmail).sendKeys("userTest5@gmail.com");
			//escribo el correo en el box email
			driver.findElement(btnCreate).click();
			//le doy click al boton Create an account
			Thread.sleep(20000); 
			//le damos tiempo a que carge la página de registro			
			
			assertEquals("userTest5@gmail.com", driver.findElement(boxEmailPreCargado).getAttribute("value"));
			//verificamos que el correo en el formulario de registro sea el mismo que ingresamos la página anterior.
		}
		else{
			System.out.println("Página no encontrada");
		}
	}

}
