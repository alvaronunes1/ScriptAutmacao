import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class TesteAutomacao {

    @Test

    public void loginAutoJur() {
        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");

        WebDriver navegador = new ChromeDriver();

        // LINK DO SITE PARA SER ACESSADO
        navegador.get("https://mcsa.autojur.com.br/login.jsf");
        //============================//======================================//

        // LOGIN E SENHA DO ACESSO - INFELIZMENTE VAI SEMPRE PEDIR A CHAVE DE ACESSO.
        navegador.findElement(By.xpath("//*[@id=\"login-form-novo:username\"]")).sendKeys("COLOQUE SEU USUARIO AQUI");
        navegador.findElement(By.xpath("//*[@id=\"login-form-novo:password\"]")).sendKeys("COLOQUE SUA SENHA AQUI");
        navegador.findElement(By.xpath("//*[@id=\"login-form-novo:btn-login\"]")).click();

        //TEMPO LIMITE PARA VOCÊ PODER PEGAR O CODIGO NO EMAIL E INSERIR
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //===================================//==============================//

        //SELECIONA O REGISTRO HISTORICO
        navegador.findElement(By.xpath("//*[@id=\"form-pesquisa-tarefa:painel-modelo-tarefa\"]/div/button")).click();
        navegador.findElement(By.xpath("//*[@id=\"form-pesquisa-tarefa:painel-modelo-tarefa\"]/div/div/div[2]/ul/li[2]/a")).click();
        //======================================//=================================================================//

        //SELECIONA A DATA DE QUANDO PEGAR ATÉ A DATA DE HOJE
        navegador.findElement(By.xpath("//*[@id=\"form-pesquisa-tarefa:data-desde_input\"]")).click();
        navegador.findElement(By.xpath("//*[@id=\"form-pesquisa-tarefa:data-desde_input\"]")).sendKeys("SELECIONE A DATA DE QUANDO - ##/##-##");
        navegador.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/button[2]")).click();
        //=========================================//==========================================//=======================//

        //ESSA LINHA APERTA O BOTÃO DE PESQUISAR
        navegador.findElement(By.xpath("//*[@id=\"form-pesquisa-tarefa:componente-pesquisa-tarefa:btn-pesquisar\"]")).click();
        //=========================================//=================================================//==========================//


        //AQUI SELECIONA A PLANILHA PARA EXPORTAÇÃO
        try {
            WebElement meuElemento = navegador.findElement(By.xpath("//*[@id=\"list-tarefas:tabela:btn-planilha\"]"));
            meuElemento.click();
        } catch (StaleElementReferenceException e) {
            WebElement meuElemento = navegador.findElement(By.xpath("//*[@id=\"list-tarefas:tabela:btn-planilha\"]"));
            meuElemento.click();
        }

        //---------------------------------------//-----------------------------------------------//-------------------------------//

        //AQUI SELECIONA A CAIXA MODELOS CADASTRADOS E DIGITA DE QUEM VOCE PRECISA PEGAR
        navegador.findElement(By.xpath("//*[@id=\"j_idt624:form-export-excel:ff-modelo\"]/div/div[1]/div/button")).click();
        navegador.findElement(By.xpath("//*[@id=\"j_idt624:form-export-excel:ff-modelo\"]/div/div[1]/div/div/div[1]/input")).click();
        navegador.findElement(By.xpath("//*[@id=\"j_idt624:form-export-excel:ff-modelo\"]/div/div[1]/div/div/div[1]/input")).sendKeys("Rodrigo");
        navegador.findElement(By.linkText("Registros Hitóricos (Público: Sim - Usuário: Rodrigo Brozinga Nunes - Limitação Perfil: Sim)")).click();

        //---------------------------------------//---------------------------------------------//------------------------------------------------//

        //AQUI É UM TEMPO PARA AGUARDAR A PESQUISA TERMINAR NA CAIXA DE MODELOS CADASTRADOS
        try {
            Thread.sleep(4000);  // 5000 milissegundos = 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //AQUI EXPORTA A PLANILHA
        navegador.findElement(By.xpath("//*[@id=\"j_idt624:form-btn-exportar:btn-exportar-planilha\"]")).click();

    }
}
