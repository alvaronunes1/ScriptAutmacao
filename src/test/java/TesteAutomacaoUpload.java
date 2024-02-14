import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TesteAutomacaoUpload {
    @Test

    public void UploadColab() {
        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");

        WebDriver navegador = new ChromeDriver();

        // LINK DO SITE PARA SER ACESSADO
        navegador.get("https://colab.research.google.com/drive/1T0U4IwuVNG9O_oHnH09N83-joTm_o7QE?usp=sharing");

        navegador.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("alvaro.nunes@mcsarc.com.br");
        navegador.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
        navegador.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Vizinpvd1$");
        navegador.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[3]")).click();
    }
}
