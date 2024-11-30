package automatizado.testes;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.pageObject.ProdutoPO;

public class ProdutoTeste extends BaseTest {

    private static ProdutoPO produtoPage;

    @BeforeClass
    public static void prepararTestes() {

        produtoPage = new ProdutoPO(driver);  // Página de produtos
        
        produtoPage.buttonAdicionar.click();
        produtoPage.buttonAdicionar.click();

    }
    
	@AfterClass
	public static void finalizar() {
		driver.quit(); //para fechar o navegador
	}

    @Test
    public void TC001_naoDeveAdicionarProdutoSemPreencherTodosOsCampos() throws InterruptedException {

        // Preenche parcialmente os campos
        produtoPage.inputCodigo.sendKeys("123");
        produtoPage.inputNome.sendKeys("Produto Teste");

        produtoPage.buttonSalvar.click(); // Tenta salvar sem preencher todos os campos obrigatórios

        // Valida a mensagem de erro exibida
        String mensagemErro = produtoPage.obterMensagemErro();
        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagemErro);
    }
    
    @Test
    public void TC002_naoDeveAdicionarProdutoComCamposVazios() {

        produtoPage.inputCodigo.sendKeys("");
        produtoPage.inputNome.sendKeys("");
        produtoPage.inputQuantidade.sendKeys("");
        produtoPage.inputValor.sendKeys("");
        produtoPage.inputData.sendKeys("");

        produtoPage.buttonSalvar.click();

        String mensagemErro = produtoPage.obterMensagemErro();

        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagemErro);
        
    }

    @Test
    public void TC003_deveAdicionarProdutoComDadosValidos() {
        
        produtoPage.inputCodigo.sendKeys("101");
        produtoPage.inputNome.sendKeys("Notebook");
        produtoPage.inputQuantidade.sendKeys("10");
        produtoPage.inputValor.sendKeys("3500");
        produtoPage.inputData.sendKeys("30/11/2024");

        produtoPage.buttonSalvar.click();

        boolean produtoAdicionado = produtoPage.isProdutoNaTabela("Notebook");

        assertEquals(true, produtoAdicionado);
    }
    
}
