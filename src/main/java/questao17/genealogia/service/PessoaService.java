package questao17.genealogia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import questao17.genealogia.model.Pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PessoaService {


    private List<Pessoa> pessoas = new ArrayList<>();

    public void criarPessoa(Pessoa pessoaNova){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaNova.getNome());
        pessoa.setIdade(pessoaNova.getIdade());
        pessoa.setPai(pessoaNova.getPai());
        pessoa.setMae(pessoaNova.getMae());
        pessoas.add(pessoa);
    }

    public void deletarPessoa (Pessoa pessoa){
        pessoas.remove(pessoa);
    }
    public List<Pessoa> listarPessoas(Pessoa pessoa){
        return pessoas;
    }
    public List<Pessoa>   exibirGenealogia(Pessoa pessoa) {
        List<Pessoa> familia = new ArrayList<>();

        familia.add(pessoa.getPai());
        familia.add(pessoa.getMae());

        return familia;
    }


}
