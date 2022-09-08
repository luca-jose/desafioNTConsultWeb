package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroUsuariosPage {
    private WebDriver navegador;

    public CadastroUsuariosPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public CadastroUsuariosPage formularioAdicionarNome(String usuario){

        navegador.findElement(By.id("field-customerName")).sendKeys(usuario);
        return this;
    }

    public CadastroUsuariosPage formularioAdicionarUltimoNome(String ultimoNome){
        navegador.findElement(By.id("field-contactLastName")).sendKeys(ultimoNome);
        return this;
    }

    public CadastroUsuariosPage formularioAdicionarNomeProprio(String nomeProprio){
        navegador.findElement(By.id("field-contactFirstName")).sendKeys(nomeProprio);
        return this;
    }

    public CadastroUsuariosPage formularioAdicionarCelular(String celular){
        navegador.findElement(By.id("field-phone")).sendKeys(celular);
        return this;
    }

    public CadastroUsuariosPage formularioAdicionarEnderecoUm( String enderecoUm){
        navegador.findElement(By.id("field-addressLine1")).sendKeys(enderecoUm);
        return this;
    }

    public CadastroUsuariosPage formularioAdicionarEnderecoDois(String enderecoDois){
        navegador.findElement(By.id("field-addressLine2")).sendKeys(enderecoDois);
        return this;
    }

    public CadastroUsuariosPage formularioAdicionarCidade(String cidade){
        navegador.findElement(By.id("field-city")).sendKeys(cidade);
        return this;
    }

    public CadastroUsuariosPage formularioAdicionarEstado(String estado){
        navegador.findElement(By.id("field-state")).sendKeys(estado);
        return this;
    }

    public CadastroUsuariosPage formularioAdicionarCep(String cep){
        navegador.findElement(By.id("field-postalCode")).sendKeys(cep);
        return this;
    }

    public CadastroUsuariosPage formularioAdicionarPais(String pais){
        navegador.findElement(By.id("field-country")).sendKeys(pais);
        return this;
    }

    public CadastroUsuariosPage formularioAdicionarEmployeeNumber(String employeeNumber){
        navegador.findElement(By.id("field-salesRepEmployeeNumber")).sendKeys(employeeNumber);
        return this;
    }

    public CadastroUsuariosPage formularioAdicionarLimiteCredito(String limiteCredito){
        navegador.findElement(By.id("field-creditLimit")).sendKeys(limiteCredito);
        return this;
    }

    public String salvarEObterMensagem(){

        navegador.findElement(By.id("form-button-save")).click();
        return navegador.findElement(By.cssSelector("div[id = 'report-success'] p")).getText();
    }

    public CadastroUsuariosPage salvarCadastro(){
        navegador.findElement(By.id("form-button-save")).click();
        return this;
    }

    public UsuariosPage voltarParaPaginaDeUsuarios(){
        navegador.findElement(By.linkText("Go back to list")).click();

        return new UsuariosPage(navegador);
    }
}
