package automatizado.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO {

    // Botão para abrir o modal de cadastro
    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;
    
    // Modal de cadastro de produto
    @FindBy(id = "cadastro-produto")
    public WebElement modalCadastroProduto;

    // Campos do modal
    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    // Botões do modal
    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;
    
    @FindBy(id = "btn-close")
    public WebElement buttonFechar;

    // Mensagem de erro no modal
    @FindBy(id = "mensagem")
    public WebElement mensagemErro;

    // Tabela de produtos
    @FindBy(css = ".table.table-hover")
    public WebElement tabelaProdutos;

    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    /**
     * Obtém a mensagem de erro exibida no modal.
     * 
     * @return A mensagem de erro.
     */
    public String obterMensagemErro() {
        return mensagemErro.getText();
    }

    /**
     * Verifica se um produto com o nome especificado está presente na tabela.
     * 
     * @param nomeProduto Nome do produto a ser verificado.
     * @return true se o produto estiver na tabela, false caso contrário.
     */
    public boolean isProdutoNaTabela(String nomeProduto) {
        return tabelaProdutos.getText().contains(nomeProduto);
    }
}
