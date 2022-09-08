package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsuariosPage {

    private WebDriver navegador;

    public UsuariosPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public UsuariosPage mudarTema(){

        navegador.findElement(By.id("switch-version-select")).click();
        navegador.findElement(By.xpath("//*[@id=\"switch-version-select\"]/option[4]")).click();
        return this;
    }

    public CadastroUsuariosPage botaoAdicionarUsuario(){
        navegador.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a")).click();
        return new CadastroUsuariosPage(navegador);
    }

    public UsuariosPage buscarUsuario(){
        navegador.findElement(By.cssSelector("input[name='customerName']")).sendKeys("Teste Sicredi");

        return this;
    }

    public UsuariosPage selecionarUm(){
        navegador.findElement(By.cssSelector("input[class='select-row']")).click();
        return this;
    }

    public UsuariosPage deletarTodos(){
        navegador.findElement(By.cssSelector("a[class='btn btn-outline-dark delete-selected-button']")).click();
        return this;
    }

    public String obterMensagemDelete(){
        return navegador.findElement(By.cssSelector("p[class='alert-delete-multiple-one']")).getText();
    }

    public UsuariosPage confirmarDelete(){
        navegador.findElement(By.cssSelector("button[class='btn btn-danger delete-multiple-confirmation-button']")).click();
        return this;
    }

    public String obterConfirmacaoDelete(){
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        String nome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"Your data has been successfully deleted from the database.\"]"))).getText();
        return nome;
    }


}
