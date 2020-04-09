package br.rommelfoxx.tasks.fuctional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("localhost:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void SalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		
		try {
			
		
		//Clicar em Add Todo 
		
		driver.findElement(By.id("addTodo")).click();
		
		//escrever descri��o 
		
		driver.findElement(By.id("task")).sendKeys("Teste via selenium");
		
		//escrever a data
		
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		
		//clicar em salvar
		
		driver.findElement(By.id("saveButton")).click();
		
		//validar mensagem de sucesso
		
		String message = driver.findElement(By.id("message")).getText();

		Assert.assertEquals("Success!", message);
		
		} finally {
		//fechar o browser
		
		driver.quit();
		}
	
	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		
		try {
			
		
		//Clicar em Add Todo 
		
		driver.findElement(By.id("addTodo")).click();
		
		
		//escrever a data
		
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		
		//clicar em salvar
		
		driver.findElement(By.id("saveButton")).click();
		
		//validar mensagem de sucesso
		
		String message = driver.findElement(By.id("message")).getText();

		Assert.assertEquals("Fill the task description", message);
		
		} finally {
		//fechar o browser
		
		driver.quit();
		}
	
	}
	
	public void naoDeveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		
		try {
			
		
		//Clicar em Add Todo 
		
		driver.findElement(By.id("addTodo")).click();
		
		//escrever descri��o 
		
		driver.findElement(By.id("task")).sendKeys("Teste via selenium");
		
		//clicar em salvar
		
		driver.findElement(By.id("saveButton")).click();
		
		//validar mensagem de sucesso
		
		String message = driver.findElement(By.id("message")).getText();

		Assert.assertEquals("Fill the due date", message);
		
		} finally {
		//fechar o browser
		
		driver.quit();
		}
	}
		
		@Test
		public void naoDeveSalvarTarefaComDataPassada() {
			WebDriver driver = acessarAplicacao();
			
			try {
				
			
			//Clicar em Add Todo 
			
			driver.findElement(By.id("addTodo")).click();
			
			//escrever descri��o 
			
			driver.findElement(By.id("task")).sendKeys("Teste via selenium");
			
			//escrever a data
			
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");
			
			//clicar em salvar
			
			driver.findElement(By.id("saveButton")).click();
			
			//validar mensagem de sucesso
			
			String message = driver.findElement(By.id("message")).getText();

			Assert.assertEquals("Due date must not be in past", message);
			
			} finally {
			//fechar o browser
			
			driver.quit();
			}
		
		}
	
}