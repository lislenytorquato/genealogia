package questao17.genealogia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import questao17.genealogia.exception.PessoaException;
import questao17.genealogia.model.Pessoa;
import questao17.genealogia.service.PessoaService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    public final static String NOME_MARIA = "Maria Santos Barros";
    public final static Integer IDADE_MARIA = 26;
    public final static String NOME_PAI_MARIA = "Mario Barros Oliveira";
    public final static Integer IDADE_PAI_MARIA = 53;
    public final static String NOME_MAE_MARIA = "Joana Santos Silva ";
    public final static Integer IDADE_MAE_MARIA = 54;


    @InjectMocks
    private PessoaService pessoaService;

    @DisplayName("1- deveria criar pessoa")
    @Test
    void deveriaCriarPessoa() throws PessoaException {

        Pessoa pai = new Pessoa(NOME_PAI_MARIA, IDADE_PAI_MARIA, null,null);
        Pessoa mae = new Pessoa(NOME_MAE_MARIA,IDADE_MAE_MARIA, null,null);

        Pessoa maria = new Pessoa(NOME_MARIA,IDADE_MARIA,pai,mae);

        List<Pessoa> pessoas = List.of(maria);

        pessoaService.criarPessoa(maria);

        Assertions.assertEquals(pessoas,pessoaService.listarPessoas());
        Assertions.assertEquals(pai,pessoaService.listarPessoas().get(0).getPai());
        Assertions.assertEquals(mae,pessoaService.listarPessoas().get(0).getMae());

    }

    @DisplayName("2- deveria exibir a genealogia")
    @Test
    void deveriaExibirGenealogia() throws PessoaException {

        Pessoa pai = new Pessoa(NOME_PAI_MARIA, IDADE_PAI_MARIA, null,null);
        Pessoa mae = new Pessoa(NOME_MAE_MARIA,IDADE_MAE_MARIA, null,null);

        Pessoa maria = new Pessoa(NOME_MARIA,IDADE_MARIA,pai,mae);

        String genealogia = pessoaService.exibirGenealogia(maria);

        Assertions.assertEquals(Boolean.TRUE,genealogia.contains(NOME_MARIA));
        Assertions.assertEquals(Boolean.TRUE,genealogia.contains(IDADE_MARIA.toString()));
        Assertions.assertEquals(Boolean.TRUE,genealogia.contains(NOME_PAI_MARIA));
        Assertions.assertEquals(Boolean.TRUE,genealogia.contains(IDADE_PAI_MARIA.toString()));
        Assertions.assertEquals(Boolean.TRUE,genealogia.contains(NOME_MAE_MARIA));
        Assertions.assertEquals(Boolean.TRUE,genealogia.contains(IDADE_MAE_MARIA.toString()));
    }

    @DisplayName("3- deveria lançar exceção ao exibir a genealogia com pai nulo")
    @Test
    void deveriaLancarExcecaoAoExibirGenealogiaComPaiNulo() throws PessoaException {

        Pessoa mae = new Pessoa(NOME_MAE_MARIA,IDADE_MAE_MARIA, null,null);

        Pessoa maria = new Pessoa(NOME_MARIA,IDADE_MARIA,null,mae);

        Assertions.assertThrows(PessoaException.class,()-> pessoaService.exibirGenealogia(maria));
    }

    @DisplayName("4- deveria lançar exceção ao exibir a genealogia com mae nulo")
    @Test
    void deveriaLancarExcecaoAoExibirGenealogiaComMaeNulo() throws PessoaException {

        Pessoa pai = new Pessoa(NOME_PAI_MARIA, IDADE_PAI_MARIA, null,null);

        Pessoa maria = new Pessoa(NOME_MARIA,IDADE_MARIA,pai,null);

        Assertions.assertThrows(PessoaException.class,()-> pessoaService.exibirGenealogia(maria));
    }

    @DisplayName("5- deveria deletar pessoa")
    @Test
    void deveriaDeletarPessoa(){
        Pessoa pai = new Pessoa(NOME_PAI_MARIA, IDADE_PAI_MARIA, null,null);
        Pessoa mae = new Pessoa(NOME_MAE_MARIA,IDADE_MAE_MARIA, null,null);

        Pessoa maria = new Pessoa(NOME_MARIA,IDADE_MARIA,pai,mae);

        pessoaService.criarPessoa(maria);
        pessoaService.deletarPessoa(maria);

        Assertions.assertEquals(0,pessoaService.listarPessoas().size());


    }

}
