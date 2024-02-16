import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

public class TesteAutomacaoUpload {
    @Test

    public void UploadColab() {
        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");

        WebDriver navegador = new ChromeDriver();

        // LINK DO SITE PARA SER ACESSADO
        navegador.get("https://colab.research.google.com/drive/1T0U4IwuVNG9O_oHnH09N83-joTm_o7QE?usp=sharing");

        // AQUI VOCE COLOCA O EMAIL DO COLAB À SER INSERIDO
        navegador.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("");
        navegador.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();

        try {
            Thread.sleep(5000);  // 5000 milissegundos = 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // AQUI VOCE COLOCA A SENHA DO EMAIL DO COLAB
        navegador.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).click();
        navegador.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("");
        navegador.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();



        //AQUI EU ESTOU TRAVANDO AS LINHAS DE COMANDO PARA DAR TEMPO SUFICIENTE DO EMAIL SER CONECTADO
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(20,1000));


        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[2]/colab-left-pane/div/div[1]/div[5]/mwc-icon-button-toggle/md-icon[1]")));
        elemento.click();
        WebElement elemento2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[2]/colab-left-pane/colab-resizer/div[1]/div[2]/colab-file-browser/colab-file-tree/div[2]/div/span")));
        elemento2.isDisplayed();

        WebElement iconElement = navegador.findElement(By.cssSelector("body > div.notebook-vertical.colab-left-pane-open > div.notebook-horizontal > colab-left-pane > colab-resizer > div.resizer-contents > div.left-pane-container > colab-file-browser > colab-file-tree > div.file-tree-buttons > paper-button > input[type=file]"));
        JavascriptExecutor js = (JavascriptExecutor) navegador;
        js.executeScript("arguments[0].click();", iconElement);

        try {
            Robot robot = new Robot();
            Thread.sleep(2000);

            //AQUI COLOCA O DIRETORIO DE ONDE ESTA O ARQUIVO XLSX
            StringSelection stringSelection = new StringSelection("EXEMPLO -----> C:\\Users\\npc\\Downloads\\Registros Hitoricos.xlsx <---- EXEMPLO");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            WebDriverWait wait4 = new WebDriverWait(navegador, Duration.ofSeconds(5));
            WebElement elemento4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/mwc-dialog/mwc-button")));
            elemento4.click();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_F9);
            robot.keyRelease(KeyEvent.VK_F9);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            WebDriverWait wait5 = new WebDriverWait(navegador, Duration.ofSeconds(5));
            WebElement elemento5 = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/mwc-dialog/mwc-button[2]")));
            elemento5.click();

            Thread.sleep(20000);

            WebElement iconElement2 = navegador.findElement(By.cssSelector("body > div.notebook-vertical.colab-left-pane-open > div.notebook-horizontal > colab-left-pane > colab-resizer > div.resizer-contents > div.left-pane-container > colab-file-browser > colab-file-tree > div.file-tree-buttons > paper-icon-button:nth-child(2)"));
            js.executeScript("arguments[0].click();", iconElement2);

            Thread.sleep(2000);

            Actions acao = new Actions(navegador);

            WebElement DIRECIONAL = navegador.findElement(By.xpath("/html/body/div[7]/div[2]/colab-left-pane/colab-resizer/div[1]/div[2]/colab-file-browser/colab-file-tree/div[3]/colab-file-view/div[1]/colab-file-view[3]/div/span"));
            acao.contextClick(DIRECIONAL).perform();

            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_DOWN);

            Thread.sleep(2000);

            WebElement LEVEL = navegador.findElement(By.xpath("/html/body/div[7]/div[2]/colab-left-pane/colab-resizer/div[1]/div[2]/colab-file-browser/colab-file-tree/div[3]/colab-file-view/div[1]/colab-file-view[4]/div/span"));
            acao.contextClick(LEVEL).perform();

            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_DOWN);

            Thread.sleep(2000);

            WebElement MOVIDA = navegador.findElement(By.xpath("/html/body/div[7]/div[2]/colab-left-pane/colab-resizer/div[1]/div[2]/colab-file-browser/colab-file-tree/div[3]/colab-file-view/div[1]/colab-file-view[5]/div/span"));
            acao.contextClick(MOVIDA).perform();

            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_DOWN);

            Thread.sleep(2000);

            WebElement MRV = navegador.findElement(By.xpath("/html/body/div[7]/div[2]/colab-left-pane/colab-resizer/div[1]/div[2]/colab-file-browser/colab-file-tree/div[3]/colab-file-view/div[1]/colab-file-view[6]/div/span"));
            acao.contextClick(MRV).perform();

            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_DOWN);

            Thread.sleep(2000);

            WebElement RSF = navegador.findElement(By.xpath("/html/body/div[7]/div[2]/colab-left-pane/colab-resizer/div[1]/div[2]/colab-file-browser/colab-file-tree/div[3]/colab-file-view/div[1]/colab-file-view[7]/div/span"));
            acao.contextClick(RSF).perform();

            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_DOWN);

            Thread.sleep(2000);

            WebElement VIC = navegador.findElement(By.xpath("/html/body/div[7]/div[2]/colab-left-pane/colab-resizer/div[1]/div[2]/colab-file-browser/colab-file-tree/div[3]/colab-file-view/div[1]/colab-file-view[8]/div/span"));
            acao.contextClick(VIC).perform();

            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_DOWN);

            Thread.sleep(2000);

            WebElement VILA = navegador.findElement(By.xpath("/html/body/div[7]/div[2]/colab-left-pane/colab-resizer/div[1]/div[2]/colab-file-browser/colab-file-tree/div[3]/colab-file-view/div[1]/colab-file-view[9]/div/span"));
            acao.contextClick(VILA).perform();

            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_DOWN);


        } catch (AWTException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }





    }
}
