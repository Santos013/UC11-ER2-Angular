package teste.eplayers;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@SuppressWarnings("unused")
public class TesteNavegaEplayers {

	ChromeDriver driver;// driver do navegador

	@Before
	public void PreTeste() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Felipe Santos\\Documents\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();// abrir navegador
		// this.driver.manage().window().maximize();
		driver.get("http://localhost:4200/");
		driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]")).click();// clicar no link login
	}

	@Test
	public void TesteNavegacao() {
		// criar os WebElements
		WebElement inputEmail = driver.findElement(By.id("usuario"));
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement inputSubmit = driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/button[1]"));
		String[] listaEmails = { "jose@mail.com", "joao@mail.com", "eduardo@mail.com", "email sem formato",
				"felipe@mail.com" };
		String[] listaSenhas = { "senhaum", "outrasenha", "senhaerrada", "123", "12345678" };

		for (int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {

			try {
				// limpar os campos
				inputEmail.clear();
				inputSenha.clear();

				// preencher os campos e submeter o formulario
				inputEmail.sendKeys(listaEmails[tentativas]);
				inputSenha.sendKeys(listaSenhas[tentativas]);
				inputSubmit.click();

				Thread.sleep(3000);

			} catch (InterruptedException error) {
				error.printStackTrace();
			}

		}

	}

	@After
	public void FinalizarTeste() {
		driver.quit();
	}

}
