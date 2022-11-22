package exselenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TestaGoogle {
	
	protected WebDriver driver;
	
	@BeforeClass
	public static void configuraDriver() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D:\\Libs\\chromedriver\\84\\chromedriver.exe");
	}
	
    @Before
    public void createDriver() {    
		driver = new ChromeDriver();
        driver.get("https://www.google.com.br");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[2]/a")).click();
		driver.findElement(By.cssSelector("button.FliLIb > span:nth-child(4)")).click();
		driver.findElement(By.cssSelector("li.G3hhxb:nth-child(2) > span:nth-child(2)")).click();
    }	

	@Test
	public void testarNomeExistente() {
		driver.findElement(By.cssSelector("#username")).sendKeys("miltonsantos");
		driver.findElement(By.cssSelector("#username")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Milton");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("Santos");
		driver.findElement(By.cssSelector("#view_container > div > div > div.pwWryf.bxPAYd > div > div.WEQkZc > div > form > span > section > div > div > div.akwVEf.OcVpRe > div.d2CFce.cDSmF.OcVpRe > div > div.LXRPh > div.ovnfwe.Is7Fhb"));
		WebElement elementTextoVermelho = driver.findElement(By.cssSelector("#view_container > div > div > div.pwWryf.bxPAYd > div > div.WEQkZc > div > form > span > section > div > div > div.akwVEf.OcVpRe > div.d2CFce.cDSmF.OcVpRe > div > div.LXRPh > div.dEOOab.RxsGPe"));
		String textoEsperado = "Este nome de usuário já está em uso. Tente outro.";
		String test = elementTextoVermelho.getText();
		assertEquals(textoEsperado, elementTextoVermelho.getText());
		//fail("Not yet implemented");
		//driver.findElement(By.cssSelector("li.G3hhxb:nth-child(2) > span:nth-child(2)")).click();
	}

	@Test
	public void testarNomeCurto() {
		driver.findElement(By.cssSelector("#username")).sendKeys("msgeo");
		driver.findElement(By.cssSelector("#username")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Milton");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("Santos");	
		
		WebElement elementTextoVermelho = driver.findElement(By.cssSelector("#view_container > div > div > div.pwWryf.bxPAYd > div > div.WEQkZc > div > form > span > section > div > div > div.akwVEf.OcVpRe > div.d2CFce.cDSmF.OcVpRe > div > div.LXRPh > div.dEOOab.RxsGPe"));
		String textoEsperado = "O seu nome de usuário deve ter entre 6 e 30 caracteres.";
		String test = elementTextoVermelho.getText();
		assertEquals(textoEsperado, elementTextoVermelho.getText());
		//fail("Not yet implemented");
		//driver.findElement(By.cssSelector("li.G3hhxb:nth-child(2) > span:nth-child(2)")).click();
	}

	@Test
	public void testarNomeCaracteresEspeciais() {
		driver.findElement(By.cssSelector("#username")).sendKeys("msgeo!");
		driver.findElement(By.cssSelector("#username")).sendKeys(Keys.ENTER);	
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Milton");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("Santos");
		String textoEsperado = "Somente letras (a - z), números (0 - 9) e pontos (.) são permitidos.";
		WebElement elementTextoVermelho = driver.findElement(By.cssSelector("#view_container > div > div > div.pwWryf.bxPAYd > div > div.WEQkZc > div > form > span > section > div > div > div.akwVEf.OcVpRe > div.d2CFce.cDSmF.OcVpRe > div > div.LXRPh > div.dEOOab.RxsGPe"));
		
		String test = elementTextoVermelho.getText();
		assertEquals(textoEsperado, elementTextoVermelho.getText());
		//fail("Not yet implemented");
		//driver.findElement(By.cssSelector("li.G3hhxb:nth-child(2) > span:nth-child(2)")).click();
	}
	
    @After
    public void quitDriver() {
       driver.quit();
    }
}
