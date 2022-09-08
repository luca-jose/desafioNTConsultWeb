package desafio;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.UsuariosPage;

import java.time.Duration;

@DisplayName("Testes Web para o Desafio 1")
public class DesafioUmTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {

        //Abrir navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //maximizar navegador
        this.navegador.manage().window().maximize();

        //tempo de espera de 10 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //navegar para pagina web
        this.navegador.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");

    }

    @Test
    @DisplayName("Validar mensagem de Sucesso na Criação - Desafio 1")
    public void testDesafioUm() {

      String mensagemSucesso = new UsuariosPage(navegador)
                .mudarTema()
                .botaoAdicionarUsuario()
                .formularioAdicionarNome("Teste")
                .formularioAdicionarUltimoNome("Teste")
                .formularioAdicionarNomeProprio("Carlos Magnum")
                .formularioAdicionarCelular("51 9999-9999")
                .formularioAdicionarEnderecoUm("Av Assis Brasil, 3970")
                .formularioAdicionarEnderecoDois("Torre Brasil")
                .formularioAdicionarCidade("Porto Alegre")
                .formularioAdicionarEstado("RS")
                .formularioAdicionarCep("99999-000")
                .formularioAdicionarPais("Brasil")
                .formularioAdicionarEmployeeNumber("Fixter")
                .formularioAdicionarLimiteCredito("200")
                .salvarEObterMensagem();
                    Assertions.assertTrue(mensagemSucesso.contains("Your data has been successfully stored into the database."));
    }

    @Test
    @DisplayName("Validar mensagem delete - Desafio 2")
    public void testDesafioDois() {

        UsuariosPage usuario = new UsuariosPage(navegador)
                .mudarTema()
                .botaoAdicionarUsuario()
                .formularioAdicionarNome("Teste")
                .formularioAdicionarUltimoNome("Teste")
                .formularioAdicionarNomeProprio("Lucas José")
                .formularioAdicionarCelular("51 9999-9999")
                .formularioAdicionarEnderecoUm("Av Assis Brasil, 3970")
                .formularioAdicionarEnderecoDois("Torres Brasil")
                .formularioAdicionarCidade("Porto Alegre")
                .formularioAdicionarEstado("RS")
                .formularioAdicionarCep("99999-000")
                .formularioAdicionarPais("Brasil")
                .formularioAdicionarEmployeeNumber("Fixter")
                .formularioAdicionarLimiteCredito("200")
                .salvarCadastro()
                .voltarParaPaginaDeUsuarios()
                .buscarUsuario()
                .selecionarUm()
                .deletarTodos();
                String mensagemDelete = usuario.obterMensagemDelete();
                    Assertions.assertEquals("Are you sure that you want to delete this 1 item?", mensagemDelete);
                usuario.confirmarDelete();
                String confirmacaoDelete = usuario.obterConfirmacaoDelete();
                    Assertions.assertEquals("Your data has been successfully deleted from the database.", confirmacaoDelete);
    }

    @AfterEach
    public void afterEach() {
        navegador.quit();
    }
}


